pipeline {
    agent {
        label 'master'
    }
    tools {
        maven 'maven'
        jdk 'java'
    }
    stages {
        stage(FixPermission) {
            agent any
            steps {
                sh 'sudo chown root:jenkins /var/run/docker.sock'
            }
        }
        stage(CleanAll) {
            steps {
                cleanWs();
                sh 'echo test'
                      git 'https://github.com/TrishaChetani/SpringRestAPIApplication.git'
            }
        }
        stage(MavenBuild) {
            steps {
              sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage(UnitTest) {
            steps {
                parallel(
                    "Unit Test": {
                        sh "mvn clean test"
                    }
                )
            }
        }
        stage(Dockerize) {
            steps {
                sh "docker-compose up"
                sh  ""
            }
        }
    }
    post {
        always {
            sh 'echo test'
        }
        failure {
           sh 'echo test'
        }
    }
}
