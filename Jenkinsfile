pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'java'
    }
    stages {
        stage(Cleanall) {
        steps {
          sh 'yes | rm -rf ./*'
         }
       }
       stage (Initialize) {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage (CheckoutSCM) {
            steps {
                 git 'https://github.com/TrishaChetani/SpringRestAPIApplication'
            }
        }
        stage(build) {
          steps {
             sh 'mvn clean'
             echo "PATH is: $PATH"
           }
        }
        stage(UnitTest) {
         steps {
        parallel(
          "Unit Test": {
            sh 'mvn test'

          },
          "Integration": {
            echo 'mvn test -P integration-test'

          },
          "Feature": {
            echo 'mvn test -P feature-test'

          }
        )
      }
    }
    stage(Installdependencies) {
      steps {
        script {
          def dockerTool = tool name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
          withEnv(["DOCKER=${dockerTool}/bin"]) {
              //stages
              //here we can trigger: sh "sudo ${DOCKER}/docker ..."
          }
        }
      }
    }
  }
}
