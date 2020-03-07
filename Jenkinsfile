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
        stage(Checkstyle) {
            steps {
                sh "mvn checkstyle:checkstyle"
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
    }
    post {
        always {
            sh 'echo Success'
        }
        failure {
            sh 'echo Failure'
        }
    }

}
