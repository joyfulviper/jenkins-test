pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Deploy') {
            steps {
                sh 'cp build/libs/demo-0.0.1-SNAPSHOT.jar /home/app/step'
                sh 'cd /home/app/step'
                echo "Deploy new application"
                sh './build.sh'
            }
        }
    }
}