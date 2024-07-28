pipeline{
    agent any
    stages {
        stage("Create_folder") {
            steps{
                sh '''mkdir sample'''
            }
        }
        stage("Create_file"){
            steps{
            sh '''touch sample.txt'''
            }
        }
        stage("File_contents"){
            steps{
            sh '''echo "Hii This is file create by pieline" >> sample.txt'''
            }
        }
        stage("File_contents"){
            steps{
            sh'''git clone https://github.com/Siddhesh1214/CODSOFT.git'''
            }
        }
    }
}