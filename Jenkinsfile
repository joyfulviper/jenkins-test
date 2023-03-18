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
                sh 'sudo chmod u+w /home/ec2-user/app/step'
                sh 'sudo cp build/libs/demo-0.0.1-SNAPSHOT.jar /home/ec2-user/app/step'
                sh 'sudo cd /home/ec2-user/app/step'
                echo "Deploy new application"
                sh 'ls'
                sh 'chmod +x ./build.sh'
                sh './build.sh'
            }
        }
    }
}