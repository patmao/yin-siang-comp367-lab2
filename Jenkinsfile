pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN3"
        jdk "JDK"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/patmao/yin-siang-comp367-lab2.git'

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean compile"
            }

        }
    }
}