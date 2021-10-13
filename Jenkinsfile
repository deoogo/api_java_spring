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
            steps{
                sh 'docker push didis/api-spring:$tag'
                sh script: $/
                 sed -i "s/didis\/api-spring:.*/didis\/api-spring:$tag/g" k8s/app_deployment.yml
                /$
                sh 'grep image k8s/app_deployment.yml '
              }

        }

        stage('Deploy'){
            steps {
                sshagent (credentials: ['github']) {
                     sh '''
                        git clone https://github.com/deoogo/api_java_spring.git
                        cd api_java_spring
                        git config --global user.name "diogo_ci"
                        git config --global user.email diogonbaa@gmail.com
                        git commit -am ' version v3'
                        git push origin main
                     '''
                  }
                 
            }

        }


        
    }
}