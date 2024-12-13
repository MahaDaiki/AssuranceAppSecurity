pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'mahadaiki/assuranceappsecurity-app'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    echo "DEBUG: Starting Checkout stage..."
                    deleteDir()
                }
                script {
                    echo "DEBUG: Fetching the repository from Git..."
                    git branch: 'main', url: 'https://github.com/MahaDaiki/AssuranceAppSecurity/'
                }
                script {
                    echo "DEBUG: Checkout stage completed successfully!"
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "DEBUG: Starting Build stage..."
                }
                sh """
                    docker run --rm -v /var/jenkins_home/workspace/AssuranceAppSecurity:/usr/src/mymaven -v /root/.m2:/root/.m2 maven:3.8.8-eclipse-temurin-17 sh -c "cd /usr/src/mymaven && mvn clean package -DskipTests"
                """
                script {
                    echo "DEBUG: Build stage completed successfully!"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo "DEBUG: Starting Build Docker Image stage..."
                }
                sh """
                    docker build -t ${DOCKER_IMAGE}:${env.BUILD_NUMBER} .
                """
                script {
                    echo "DEBUG: Docker Image built successfully!"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    echo "DEBUG: Starting Push Docker Image stage..."
                }
                withDockerRegistry([credentialsId: 'dockerpass', url: 'https://index.docker.io/v1/']) {
                    sh "docker push ${DOCKER_IMAGE}:${env.BUILD_NUMBER}"
                }
                script {
                    echo "DEBUG: Docker Image pushed successfully!"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "DEBUG: Starting Deployment..."
                }
                sh """
                    docker-compose down || true
                    docker-compose up -d
                """
                script {
                    echo "DEBUG: Deployment completed!"
                }
            }
        }
    }

    post {
        always {
            echo 'DEBUG: Pipeline completed successfully'
        }
        failure {
            echo 'DEBUG: Pipeline failed'
        }
    }
}
