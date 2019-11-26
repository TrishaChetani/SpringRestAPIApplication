pipeline {
    environment {
        registry = "trisha1212/springticket"
        registryCredential = 'dockerhub'
    }
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
        stage(BuildingImage) {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage(DeployImage) {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
        post {
            always {
                sh 'echo build success'
            }
            failure {
                sh 'echo build failure'
            }
        }
    }
}
