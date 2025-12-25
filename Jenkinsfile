pipeline {
    agent any

    environment {
        TARGET_URL = "https://example.com"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('URL Check (JUnit)') {
  steps {
    sh '''
      set -e
      chmod +x mvnw
      ./mvnw -q -e -f demo/pom.xml -DtargetUrl=${TARGET_URL} test
    '''
  }
  post {
    always {
      junit 'demo/target/surefire-reports/*.xml'
    }
  }
}

        stage('Deploy') {
            steps {
                echo "✅ URL reachable, Deploy stage running..."
                // burada deploy komutun neyse
                // sh './deploy.sh'
            }
        }
    }
}
