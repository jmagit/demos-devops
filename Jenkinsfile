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
        }
        stage("SonarQube Analysis") {
            steps {
                withSonarQubeEnv('SonarQubeDockerServer') {
                    sh 'mvn clean verify sonar:sonar'
                }
                timeout(5) { // time: 5 unit: 'MINUTES'
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
}
