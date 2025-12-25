pipeline {
  agent any

  environment {
    TARGET_URL = 'https://example.com'
  }

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
        dir('demo') {
          sh '''
            set -e
            chmod +x mvnw
            ./mvnw -q -e -DtargetUrl="$TARGET_URL" test
          '''
        }
      }
      post {
        always {
          junit 'demo/target/surefire-reports/*.xml'
        }
      }
    }

    stage('Deploy') {
      when {
        expression { currentBuild.currentResult == 'SUCCESS' }
      }
      steps {
        echo "✅ URL erişilebilir. Deploy çalışıyor..."
        // burada gerçek deploy komutun neyse:
        // sh 'echo deploy...'
      }
    }
  }
}
