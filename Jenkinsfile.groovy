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
                sh 'pgrep -f demo.*.jar'
                CURRENT_PID = sh(script: "pgrep -f demo.*.jar", returnStdout: true).trim()
                echo "Current PID: ${CURRENT_PID}"
                if (CURRENT_PID) {
                    echo "Kill ${CURRENT_PID}"
                    sh "kill ${CURRENT_PID}"
                    sleep 5
                }
                echo "Deploy new application"
                sh "nohup java -jar /home/app/step/*.jar 2>&1 &"
            }
        }
    }
}