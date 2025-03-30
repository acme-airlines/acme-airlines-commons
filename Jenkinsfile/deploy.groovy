pipeline {
  agent { label 'ubuntu-latest' }

  environment {
    // Se obtienen las credenciales de GitHub desde el almacén de credenciales de Jenkins
    GITHUB_TOKEN = credentials('github-token')
    GITHUB_USERNAME = credentials('github-username')
    // Para este ejemplo, el repositorio se asume que es "OWNER/REPO". Cámbialo según corresponda.
    GITHUB_REPO = "OWNER/REPO"
  }
  
  tools {
    jdk 'JDK17'         // Nombre de la configuración de JDK 17 en Jenkins
    maven 'Maven3'      // Nombre de la configuración de Maven en Jenkins
  }

  stages {
    stage('Checkout Source Code') {
      steps {
        checkout scm
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

    stage('Bump version and push tag') {
      steps {
        script {
          // Simulación: se asigna una nueva versión.
          // En una implementación real podrías extraer la versión actual del pom.xml y calcular la siguiente.
          env.NEW_VERSION = "1.0.1"
        }
        echo "New version is ${env.NEW_VERSION}"
        sh '''
          git config user.email "mariafvn0127@gmail.com"
          git config user.name "MariaFernanda1818"
          git tag ${NEW_VERSION}
          git push origin ${NEW_VERSION}
        '''
      }
    }

    stage('Set new version in pom.xml') {
      steps {
        sh '''
          mvn versions:set -DnewVersion=${NEW_VERSION}
          git add pom.xml
          git commit -m "Set version to ${NEW_VERSION}"
          git push origin HEAD:main
        '''
      }
    }

    stage('Build and Deploy with Maven') {
      steps {
        sh 'mvn clean deploy -Pproduction'
      }
    }

    stage('Create GitHub Release') {
      steps {
        sh '''
          curl -s -X POST https://api.github.com/repos/${GITHUB_REPO}/releases \\
          -H "Authorization: token ${GITHUB_TOKEN}" \\
          -d '{
            "tag_name": "${NEW_VERSION}",
            "target_commitish": "main",
            "name": "Release ${NEW_VERSION}",
            "body": "Release ${NEW_VERSION}",
            "draft": false,
            "prerelease": false
          }'
        '''
      }
    }

    stage('Push new version to repository') {
      steps {
        sh '''
          git config user.email "mariafvn0127@gmail.com"
          git config user.name "MariaFernanda1818"
          git add pom.xml
          git commit -m "Set version to ${NEW_VERSION}"
          git push origin main
        '''
      }
    }
  }
}
