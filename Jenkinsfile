pipeline {
    agent none
    tools {
        maven 'maven'
        jdk 'java'
    }
    stages {
        stage(Fixpermission) {
            agent any
            steps {
            //    sh 'sudo chown root:jenkins /var/run/docker.sock'
                sh 'echo test'
            }
        }
        stage(Cleanall) {
            steps {
                cleanWs();
                sh 'echo test'
           }
        }
       stage(MavenBuild) {
            steps {
                sh 'mvn clean package'
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
        stage(Dockerize) {
            steps {
             sh 'echo test'
            }
        }
    }
    post {
        success {
          sh 'echo test'
        }
        failure {
            sh 'echo test'
        }
    }
}

