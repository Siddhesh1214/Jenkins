pipeline {
    agent {
        label 'student-app'
        } 
    stages{
        stage('Pull a file from git')
        {
            steps{
                sh'''git clone https://github.com/Mayur2905/webapp.git''' 
            }
        }
        stage('Installing Apache2') {
            steps{
                sh'''sudo apt-get install apache2 -y'''
                sh'''sudo systemctl start apache2'''
            }
        }
        stage('Downloading Tomcat 8') {
            steps{
                sh'''sudo wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.99/bin/apache-tomcat-8.5.99.tar.gz'''
                sh'''sudo tar -xvf apache-tomcat-8.5.99.tar.gz'''
            }
        }
        stage('Deploying war file') {
            steps{
                sh''' sudo cp -r webapp/student.war apache-tomcat-8.5.99/webapps'''
            }
        }
        stage('Starting Apache 8') {
            steps{
                sh'''sudo ./apache-tomcat-8.5.99/bin/startup.sh '''
            }
        }
    }
}
