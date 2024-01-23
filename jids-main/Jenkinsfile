pipeline {
    
    agent any

    stages {

        stage('Build') {
            steps {
                script{
                sh("mvn clean install -DskipTests")
                }
            }
        }

        stage('Test') {
            steps {
                script{
                 sh("mvn test")
                }
            }
        }

        stage('Setup') {
            steps {
                script{
                 sh("sudo cp /test/rules.conf ./rules.conf")
                 sh 'cat rules.conf'
                }
            }
        }


        stage('Deploy') {
            steps {
                script{
                sh("sudo nohup java -jar jids-1.0-SNAPSHOT-jar-with-dependencies.jar 127.0.0.1 &> /dev/null &")
                }
            }
        }
    }
}