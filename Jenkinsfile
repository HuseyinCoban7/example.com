pipeline {
  agent none

  stages {
    stage('URL Check (JUnit)') {
      agent {
        docker {
          image 'maven:3.9.6-eclipse-temurin-17'
          args '-v $HOME/.m2:/root/.m2'
        }
      }
      steps {
        dir('url-check') {
          sh 'mvn -q test'
        }
      }
      post {
        always {
          junit 'url-check/target/surefire-reports/*.xml'
        }
      }
    }

    stage('Deploy') {
      agent any
      steps {
        echo 'Deploy çalıştı (URL erişilebilir olduğu için).'
        // burada gerçek deploy komutların olur
      }
    }
  }
}
