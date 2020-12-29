pipeline{
    environment {
        dockercontainername = "AnalysisFrontend"
        imagename = "dqf/dqf_analysis_frontend"
        dockerImage = ''
    }


    agent any
    stages{
        stage('Build'){
            steps{
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
        stage('Build docker Image'){
            steps{
                script{
                    dockerImage = docker.build imagename
                }
            }
        }
        stage('remove existing image'){
            steps{
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "docker stop ${dockercontainername}"
                    sh "docker rm -f ${dockercontainername}"
                }
            }
        }
        stage('Run Docker container'){
            steps{
                sh "docker run -d -p 80:8080 --network dqf-net --name ${dockercontainername} ${imagename}"
            }
        }
    }
}