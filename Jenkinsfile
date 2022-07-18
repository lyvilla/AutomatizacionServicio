pipeline {
    agent any
    environment {
        VERSION = "${BUILD_NUMBER}"
        REPO = 'https://github.com/lyvilla/AutomatizacionServicio.git'
        RAMA = 'main'
    }
  
    stages {
        stage('Descargar codigo') {
            steps {
                echo 'Descargando código...'
                git url: "${REPO}", branch: "${RAMA}"
            }
        }
        
    stage('Sonarqube') {
          steps {
              echo 'Escaneando código...'
              bat 'gradle sonarqube'
            }
        }

        stage('Build') {
            steps {
                echo 'Corriendo los test...'
                bat 'gradle clean test aggregate'
            }
        }
        
        stage('Publish report') {
            steps {
                echo 'Publicando reporte de serenity...'
                publishHTML (target: [
                  allowMissing: true,
                  alwaysLinkToLastBuild: true,
                  keepAll: true,
                  reportDir: 'target/site/serenity',
                  reportFiles: 'index.html',
                  reportName: 'Reporte de serenity'
                              ])
            }
        }
    }
}
