pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew build'
            }
        }
        stage('Deploy') {
            steps {
                sh 'cp build/libs/demo-0.0.1-SNAPSHOT.jar /home/app/step'
                sh 'cd /home/app/step'
                echo "Deploy new application"
                sh 'chmod +x ./build.sh'
                sh './build.sh'
            }
        }
    }
}