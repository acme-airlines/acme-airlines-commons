pipeline {
  agent { label 'ubuntu-latest' }

  environment {
    // Se obtienen las credenciales de GitHub desde el almacén de credenciales de Jenkins
    GITHUB_TOKEN = credentials('github-token')
    GITHUB_USERNAME = credentials('github-username')
    // Actualiza OWNER/REPO por tu repositorio real, por ejemplo: "acme-airlines/acme-airlines-commons"
    GITHUB_REPO = "acme-airlines/acme-airlines-commons"
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
          // Leer la versión actual del pom.xml y aumentar el número de parche
          def currentVersion = sh(script: "grep -m 1 '<version>' pom.xml | sed 's/.*<version>\\([^<]*\\)<\\/version>.*/\\1/'", returnStdout: true).trim()
          echo "Current version: ${currentVersion}"
          def parts = currentVersion.tokenize('.')
          def major = parts[0] as int
          def minor = parts[1] as int
          def patch = parts[2] as int
          patch = patch + 1
          env.NEW_VERSION = "${major}.${minor}.${patch}"
          echo "New version is ${env.NEW_VERSION}"
        }
        // Configurar git y hacer push del tag usando las credenciales
        sh '''
          git config user.email "mariafvn0127@gmail.com"
          git config user.name "MariaFernanda1818"
          git tag ${NEW_VERSION}
          git push https://${GITHUB_USERNAME}:${GITHUB_TOKEN}@github.com/${GITHUB_REPO}.git ${NEW_VERSION}
        '''
      }
    }

    stage('Set new version in pom.xml') {
      steps {
        sh '''
          mvn versions:set -DnewVersion=${NEW_VERSION}
          git add pom.xml
          git commit -m "Set version to ${NEW_VERSION}"
          git push https://${GITHUB_USERNAME}:${GITHUB_TOKEN}@github.com/${GITHUB_REPO}.git HEAD:main
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
          git push https://${GITHUB_USERNAME}:${GITHUB_TOKEN}@github.com/${GITHUB_REPO}.git main
        '''
      }
    }
  }
}
