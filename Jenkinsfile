pipeline {
    agent any

    parameters {
        choice (name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: "versions to chose, to deploy on prod")
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Run tests during the build')
    }
    
    stages {
        stage("build") {
            steps {
                echo 'Building the application...'
            }
        }

        stage("test") {
            steps {
                echo 'Testing the application...'
            }
        }

        stage("deploy") {
            steps {
                echo 'Deploying the application...'
                echo "Deploying the application version ${param.VERSION}"
            }
        }
    }
}