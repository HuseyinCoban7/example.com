pipeline {
  agent any

  options {
    timestamps()
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('URL Check (JUnit)') {
      steps {
        dir('url-check') {
          sh 'mvn -q -e test'
        }
      }
      post {
        always {
          // test raporu Jenkins'te görünür
          junit allowEmptyResults: true, testResults: 'url-check/target/surefire-reports/*.xml'
        }
      }
    }

    stage('Deploy') {
      // Önceki stage başarısızsa buraya zaten gelmez (pipeline fail olur)
      steps {
        echo "Deploy çalışıyor..."
        // burada kendi deploy komutların olur:
        // sh './deploy.sh'  veya  sh 'docker compose up -d'  vs.
      }
    }
  }
}
