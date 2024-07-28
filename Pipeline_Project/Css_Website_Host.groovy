pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh'''
                echo 1234 | sudo -S apt update -y
                sudo rm -rf /var/www/html/*
                sudo wget https://www.free-css.com/assets/files/free-css-templates/download/page293/fonicy.zip
                '''
            }
        }
        stage('Test') {
            steps {
                sh'''
                echo 1234 | sudo -S apt update -y
                sudo apt install unzip
                sudo unzip fonicy.zip
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh'''
                echo 1234 | sudo -S apt update -y
                echo 1234 |sudo -S cp -r fonicy-html /var/www/html/
                '''
            }
        }
    }
}