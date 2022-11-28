pipeline {
    agent any
    triggers { // Sondear repositorio a intervalos regulares
        pollSCM('* * * * *')
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
                    echo "JENKINS_VERSION = ${JENKINS_VERSION}"
                ''' 
            }
        }
        stage("Compile") {
            steps {
                sh "mvn compile"
            }
        }
        stage("Unit test") {
            steps {
                sh "mvn test"
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage("SonarQube Analysis") {
            steps {
                withSonarQubeEnv('SonarQubeDockerServer') {
                    sh 'mvn clean verify sonar:sonar'
                }
                timeout(2) { // time: 2 unit: 'MINUTES'
                  // In case of SonarQube failure or direct timeout exceed, stop Pipeline
                  waitForQualityGate abortPipeline: waitForQualityGate().status != 'OK'
                }
            }
        }
        stage("Build") {
            steps {
                sh "mvn package -DskipTests"
            }
        }
        stage("Deploy") {
            steps {
                sh "mvn install -DskipTests"
            }
        }
    }
    post {
        always {
            mail to: 'team@example.com',
                subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
                body: "${env.BUILD_URL} has result ${currentBuild.currentResult}"
        }
    }
}
