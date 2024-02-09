pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage ("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script{
                    gv.buildJar()
                }
            }
        }
        stage ("build stage") {
            steps {
                script {
                    gv.buildImageAndPushToDocker()
                }
            }
        }
        stage("deploy") {
            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    }
}