def gv

pipeline {
    agent any
    tools {
        maven "maven-3.9"
    }
    stages {
        // initialisation
        stage ("init"){
            steps {
                script {
                    gv = load 'myscript.groovy'
                }
            }
        }

        // building java artifact
        stage("build jar") {
            steps {
                script{
                    gv.buildJar()
                }
            }
        }
        
        stage("build docker image") {
            steps {
                script{
                    gv.buildImage()
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