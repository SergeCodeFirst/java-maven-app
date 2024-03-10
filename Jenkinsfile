#!/user/bin/env groovy
// @Library('jenkins-shared-library') // global import from jenkins (we add it there in a global library)
library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/SergeCodeFirst/jenkins-shared-library.git',
    credentialsId: 'github-credentials'
    ])

// @Library('jenkins-shared-library')_ // keep "_" if after the import we have the pipeline tag

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    environment {
        IMAGE_NAME = 'sergevismok/demo-app:java-maven-1.0'
    }
    stages {
        stage("build app") {
            steps {
                script{
                    echo 'building application jar...'
                    buildJar()
                }
            }
        }
        stage ("build and push image stage") {
            steps {
                script {
                    echo 'bulding the docker image...'
                    dockerBuildImage(env.IMAGE_NAME)
                    dockerLogin()
                    dockerPush(env.IMAGE_NAME)
                }
            }
        }
        stage("deploy") {
            steps {
                script{
                    echo "Start Deploying the image to EC2..."
                    def shellCmd = "bash ./server-cmds.sh ${env.IMAGE_NAME}"
                    sshagent(['ec2-server-key']) {
                        sh "scp docker-compose.yaml ec2-user@54.90.134.212:/home/ec2-user"
                        sh "scp server-cmds.sh ec2-user@54.90.134.212:/home/ec2-user"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@54.90.134.212 ${shellCmd}"
                    }
                    echo "Deployment Complete Successfully..."
                }
            }
        }
    }
}