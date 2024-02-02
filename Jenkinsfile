pipeline {
    stages {
        stage("Test") {
            steps {
                script{
                    echo "Testing the application..."
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script{
                    echo "Building the application..."
                }
            }
        }
        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script{
                    echo "Deploying the application..."
                }
            }
        }
    }
}