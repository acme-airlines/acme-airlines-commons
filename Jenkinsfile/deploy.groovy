pipeline {
  agent { label 'ubuntu-latest' }
  
  environment {
    // Credenciales configuradas en Jenkins (asegúrate de tener las credenciales con estos IDs)
    GITHUB_TOKEN = credentials('github-token')
    GITHUB_USERNAME = credentials('github-username')
    // Usar "owner/repo" sin URL ni .git
    GITHUB_REPO = "acme-airlines/acme-airlines-commons"
  }
  
  tools {
    jdk 'JDK17'         // Nombre de la instalación de JDK 17 en Jenkins
    maven 'Maven3'      // Nombre de la instalación de Maven en Jenkins
  }

  stages {
    stage('Checkout Source Code') {
      steps {
        // Realizamos un checkout explícito para asegurar que se clone el repositorio
        checkout([$class: 'GitSCM',
                  branches: [[name: '*/main']],  // Asegúrate de que 'main' es la rama correcta; cámbiala si es necesario.
                  doGenerateSubmoduleConfigurations: false,
                  extensions: [],
                  userRemoteConfigs: [[
                    url: "https://github.com/${GITHUB_REPO}",
                    credentialsId: 'github-token'
                  ]]
        ])
        
        // Paso opcional para verificar que se clonó el repositorio correctamente
        sh 'ls -la'
      }
    }
    
    stage('Set up Maven settings') {
      steps {
        sh '''
          mkdir -p ~/.m2
          cat > ~/.m2/settings.xml <<EOF
          <settings>
            <servers>
              <server>
                <id>github</id>
                <username>${GITHUB_USERNAME}</username>
                <password>${GITHUB_TOKEN}</password>
              </server>
            </servers>
          </settings>
EOF
        '''
      }
    }
    
    stage('Build and Test') {
      steps {
        sh 'mvn clean verify'
      }
    }
    
    stage('Build and Deploy with Maven') {
      steps {
        sh 'mvn clean deploy -Pproduction'
      }
    }
  }
}
