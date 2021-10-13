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
            environment { 
            GIT_AUTH = credentials('github') 
            }
            steps {
                sh('''
                    git checkout -B main
                    git config user.name 'my-ci-user'
                    git config user.email 'my-ci-user@users.noreply.github.example.com'
                    git add . && git commit -am "v3"

                    git config --local credential.helper "!f() { echo username=\\$GIT_AUTH_USR; echo password=\\$GIT_AUTH_PSW; }; f"
                    git push origin main
                ''')
            }
        }    
           
     }




        
    }
}