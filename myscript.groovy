def buildApp() {
    echo "Building application..."
}

def testApp() {
    echo "Testing application..."
}

def deployApp() {
    echo 'Deploying the application...'
    echo "Deploying the application version ${param.VERSION}"
}
return this
