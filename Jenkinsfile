pipeline {
  agent {
    docker {
      image 'maven:3.9.9-eclipse-temurin-17'
      args  '-v $HOME/.m2:/root/.m2'
    }
  }

  environment {
    TARGET_URL = 'https://example.com'
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
          mvn -q -e -f demo/pom.xml -DtargetUrl=${TARGET_URL} test
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
        echo "Deploy çalıştı çünkü URL erişilebilir ve testler geçti."
        // buraya deploy komutunu koyacaksın (ör: sh '...deploy...')
      }
    }
  }
}
