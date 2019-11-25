pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'java'
    }
    stages {

       stage('Clean All') {
        steps {
          sh 'yes | rm -rf ./*'

              }
       }

        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('checkout from SCM') {
            steps {
                 git 'https://github.com/TrishaChetani/SpringRestAPIApplication'
            }
        }

          stage("Checkstyle") {
                    sh "mvn checkstyle:checkstyle"

                    step([$class: 'CheckStylePublisher',
                      canRunOnFailed: true,
                      defaultEncoding: '',
                      healthy: '100',
                      pattern: '**/target/checkstyle-result.xml',
                      unHealthy: '90',
                      useStableBuildAsReference: true
                    ])
                }
            }

        stage('Build') {
          steps {
             sh 'mvn clean install -DskipTests'


           }
        }
        stage('Unit Test') {
         steps {
        parallel(
          "Unit Test": {
            sh 'mvn test -P unit-test'

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
  }
}
