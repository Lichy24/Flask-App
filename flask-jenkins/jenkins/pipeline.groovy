pipeline {
    agent {
        node {
            label 'built-in'
            customWorkspace 'S:/dev ops course/project'
        }
    }
    environment {
        BUILD_NUMBER = "5"
        REGISTRY     = 'lichy24'
        IMAGE_NAME   = 'flask-app'
        HELM_RELEASE = 'flask-package'
        IMAGE_TAG    = "1.1.${BUILD_NUMBER}" 
        // Combine them for ease of use
        FULL_IMAGE   = "${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}"
        HELM_CHART_PATH = "./flask-package"
        CONTAINER_NAME = "flask-app-${BUILD_NUMBER}"
        MONGODB_USERNAME = "admin"
        MONGODB_PASSWORD = "pss321"
    }
    stages {
        stage('Build') {
            steps {
                script {
                echo 'Building...'
                if (isUnix()){
                    dir('flask-docker'){
                        sh "docker build -t ${FULL_IMAGE} ."
                        sh "minikube image load ${FULL_IMAGE}"
                    }

                }
                else {
                    dir('flask-docker'){
                        bat "docker build -t ${FULL_IMAGE} ."
                        bat "minikube image load ${FULL_IMAGE}"
                    }
                }
                }
          }
        }
        stage('Test') {
            steps {
                script {
                echo 'Testing...'
                if (isUnix()){
                    sh "docker run -p 8080:8080 -d --name ${CONTAINER_NAME} ${FULL_IMAGE}"
                    sh "docker stop ${CONTAINER_NAME} && docker rm ${CONTAINER_NAME}"


                }
                else {
                    bat "docker run -p 8080:8080 -d --name ${CONTAINER_NAME} ${FULL_IMAGE}"
                    bat "docker stop ${CONTAINER_NAME} && docker rm ${CONTAINER_NAME}"
                }
                }
            }
        }
        stage('Deployment') {
            steps {
                script {
                echo 'Deploying...'
                if (isUnix()){
                    dir('flask-package') {
                        sh "helm install ${HELM_RELEASE} . --set secert.data.mongodb-username=\"${MONGODB_USERNAME}\" --set secert.data.mongodb-password=\"${MONGODB_PASSWORD}\" --set image.repository=\"${REGISTRY}/${IMAGE_NAME}\" --set image.tag=\"${IMAGE_TAG}\""
                        sh "helm test ${HELM_RELEASE} --logs"
                        sh "helm uninstall ${HELM_RELEASE}"
                    }
                }
                else {
                    dir('flask-package') {
                        bat "helm install ${HELM_RELEASE} . --set secert.data.mongodb-username=\"${MONGODB_USERNAME}\" --set secert.data.mongodb-password=\"${MONGODB_PASSWORD}\" --set image.repository=\"${REGISTRY}/${IMAGE_NAME}\" --set image.tag=\"${IMAGE_TAG}\""
                        bat "helm test ${HELM_RELEASE} --logs"
                        bat "helm uninstall ${HELM_RELEASE}"
                    }
                }
                }
            }
        }
    }

}