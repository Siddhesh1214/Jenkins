pipeline{
    agent{
        label 'Webhook'
    
    }
    stages{
        stage('Pull a file from git')
        {
            steps{
                git 'https://github.com/Spidy20/InNews.git'
            }
        }
        stage('Installing Python')
        {
            steps{
                sh " sudo apt-get update"
                sh " sudo apt-get install python3 -y"
                sh " sudo apt install python3-pip -y"
            }
        }
        stage('Installing Requirements')
        {
            steps{
                sh "sudo pip3 install -r requirements.txt"
            }
        }
        stage('Streamlit')
        {
            steps{
                sh " sudp pip3 install streamlit"
            }
        }
        stage('Run App')
        {
            steps{
                sh " sudo python3 -m streamlit run App.py"
            }
        }
    }
}