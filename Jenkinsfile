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
                sh('''
                    rm -rf /tmp/api_java_spring
                    cd /tmp
                    git clone git@github.com:deoogo/api_java_spring.git
                    cp /var/lib/jenkins/workspace/teste/k8s/app_deployment.yml /tmp/api_java_spring/k8s/app_deployment.yml
                    cd /tmp/api_java_spring
                    git config user.name 'my-ci-user'
                    git config user.email 'diogonbaa@jenkins'
                    git add . && git commit -am "v3"
                    git push origin main
                ''')
            }
        }    
           
     }       
    
    }
