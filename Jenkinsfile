#!/user/bin/env groovy
@Library('jenkins-shared-library')
def gv
// @Library('jenkins-shared-library')_ // keep "_" if after the import we have the pipeline tag

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
                    buildJar()
                }
            }
        }
        stage ("build stage") {
            steps {
                script {
                    buildImageAndPushToDocker "sergevismok/demo-app:jma-3.0"
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