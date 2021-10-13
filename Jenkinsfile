pipeline {
    agent any
    
    stages{
        stage('Baixando o Repo'){
            steps {
                git url: 'https://github.com/deoogo/api_java_spring.git', branch: 'main' 
            }

        }

        stage('Build da aplicação'){
            steps {
                 sh 'mvn -B -DskipTests clean package'
            }

        }

        stage('Build Image Docker'){
            steps {
                sh 'docker build --build-arg JAR_FILE=target/*.jar -t didis/api-spring:$tag .' 
            }

        }

        stage('Docker push Image'){
            script {
                docker.withRegistry('https://registry.hub.docker.com','dockerhub')
                docker.push('$tag') 
            }

        }


        
    }
}