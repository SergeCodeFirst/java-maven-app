def gv

pipeline {
    agent any
    parameters {
        choice (name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: "versions to chose, to deploy on prod")
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Run tests during the build')
    }
    
    stages {
        stage("init") {
            steps {
                script{
                    gv = load "myscript.groovy"
                }
            }
        }
        
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            input {
                message "Select the environment to deploy to"
                ok "Done"
                parameters {
                    choice (name: 'ENV', choices: ['dev', 'staging', 'prod'], description: "versions to chose, to deploy on prod")
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "Deploying to ${ENV}..."
                }
            }
        }
    }
}