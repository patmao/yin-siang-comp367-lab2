pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN3"
    }

    stages {
        stage('Checkout and Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'master', url: 'https://github.com/patmao/yin-siang-comp367-lab2'
                // Run Maven with Jacoco for code coverage
                bat "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package"
            }
            post {
                success {
                    junit '/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        stage("Code Coverage") {
            steps {
                script {
                    // Publish Jacoco coverage report
                    bat "mvn org.jacoco:jacoco-maven-plugin:report"
                    jacoco(execPattern: 'target/.exec')
                }
                
            }
        }
        
        stage("Login to Docker Hub") {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        bat 'docker login -u patmao -p "patrick335220"'
                    }
                }
            }
        }
        
        stage("Build Docker Image") {
            steps {
                script {
                    bat "docker build -t patmao/yinsiangmao_comp367_lab2 ."
                }
            }
        }
        
        stage("Push Image to Docker Hub") {
            steps {
                script {
                    bat 'docker push patmao/yinsiangmao_comp367_lab2 '
                }
            }
        }
    }
}