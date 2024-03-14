pipeline {
    agent any

    tools {
        maven "MAVEN3"
        jdk "JDK"
    }

    stages {
        stage('Checkout and Build') {
            steps {
                git branch: 'master', url: 'https://github.com/patmao/yin-siang-comp367-lab2'
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
                    bat "mvn org.jacoco:jacoco-maven-plugin:report"
                    jacoco(execPattern: 'target/.exec')
                }
                
            }
        }
        
        stage("Login to Docker Hub") {
            steps {
                script {
                   
                       bat 'docker login -u patmao -p "patrick335220"'
                   
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
                    bat 'docker push patmao/yinsiangmao_comp367_lab2'
                }
            }
        }
    }
}