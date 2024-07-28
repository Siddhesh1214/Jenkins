pipeline {
    agent {
        label 'maven'
        } 
    stages{
        stage('Pull a file from git')
        {
            steps{
                git 'https://github.com/AnupDudhe/studentapp-ui'
            }
        }
        stage('Maven Install')
        {
            steps{
                 sh'''sudo apt install maven -y'''
                 sh'''mvn clean ''' 
                 sh'''mvn package'''
            }  
        }
        stage('Installing Apache')
        {
            steps{
                sh "sudo apt-get update"
                sh "  sudo  apt-get install apache2 -y"
                sh "  sudo  systemctl start apache2"
                
            }
        }
        stage('Downloading Tomcat')
        {
            steps{
                sh 'sudo wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.99/bin/apache-tomcat-8.5.99.tar.gz'
                sh 'sudo tar -xvf apache-tomcat-8.5.99.tar.gz'
            }
        }
        stage('Deploying war file')
        {
            steps{
                sh "  sudo  mv target/*.war apache-tomcat-8.5.99/webapps/student.war"
            }
        }
        stage('Starting Apache 8')
        {
            steps{
                sh 'sudo ./apache-tomcat-8.5.99/bin/startup.sh'
            }
        }
    }
}
