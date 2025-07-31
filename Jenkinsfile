pipeline {
    agent any
    stages {
        stage ("copy files to ansible server") {
            steps {
                script {
                    echo "copying all necessary files to ansible control node"
                    sshagent(['ansible-server-key']) {
                        sh "scp -o StrictHostKeyChecking=no ansible/* root@165.22.5.32:/root"

                        withCredentials([sshUserPrivateKey(credentialsId: 'ec2-server-key', keyFileVariable:'keyfile', usernameVariable:'user')]) {
                            sh 'scp $keyfile root@165.22.5.32:/root/ssh-key.pem'
                        }
                    }
                }
            }
        }

        stage ("Execute ansible playbook") {
            steps {
                script {
                    echo "calling ansible playbook to configure ec2 instance"

                    def remote = [:]
                    remote.name = "ansible-server"
                    remote.host = "165.22.5.32"
                    remote.allowAnyHosts = true

                    withCredentials([sshUserPrivateKey(credentialsId: 'ansible-server-key', keyFileVariable:'keyfile', usernameVariable:'user')]) {
                        remote.user = user
                        remote.identityFile = keyfile
                        sshCommand remote: remote, command: "ls -l"
                    }
                }
            }
        }
    }
}