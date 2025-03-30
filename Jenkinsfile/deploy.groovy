stage('Set new version in pom.xml') {
  steps {
    sh '''
      # Actualiza la versión sin generar backup
      mvn versions:set -DnewVersion=${NEW_VERSION} -DgenerateBackupPoms=false
      
      # Asegúrate de estar en la rama main
      git checkout main
      
      # Agrega el archivo modificado
      git add pom.xml
      
      # Realiza el commit; si no hay cambios, no falla el stage
      git commit -m "Set version to ${NEW_VERSION}" || echo "No changes to commit"
      
      # Empuja los cambios a la rama main
      git push https://${GITHUB_USERNAME}:${GITHUB_TOKEN}@github.com/${GITHUB_REPO}.git main
    '''
  }
}
