pipeline {
    agent any
    
    stages{
        stage('Baixando o Repo'){
            steps {
                git url: 'https://github.com/deoogo/api_java_spring.git', branch: 'main' 
            }

        }
        stage('Build Image Docker'){
            steps {
                script{
                    dockerpp = docker.build("didis/api-spring:${env.BUILD}", '-f ./Dockerfile .')
                } 
            }

        }
        
    }
}