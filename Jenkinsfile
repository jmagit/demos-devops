pipeline {
    agent any
    triggers { // Sondear repositorio a intervalos regulares
        pollSCM('* * * * *')
    }
    tools {
        maven "maven_lts"
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
                    recordCoverage(tools: [[parser: 'JACOCO']])
                    //jacoco sourceInclusionPattern: '**/*.java'
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
        stage('Build & Site') {
            parallel {
                when {
                    branch 'production'
                } 
                stage("Build") {
                    steps {
                        sh "mvn package -DskipTests"
                        archiveArtifacts 'target/*.jar'
                    }
                }
                stage("Site") {
                    steps {
                        sh "mvn site"
                    }
                    post {
                        success {
                            publishHTML([
                                allowMissing: false, 
                                alwaysLinkToLastBuild: false, 
                                keepAll: false, 
                                reportDir: 'target/site/', 
                                reportFiles: 'index.html', 
                                reportName: 'Documentacion del sitio', 
                                reportTitles: 'Documentacion del sitio', 
                                useWrapperFileDirectly: true
                                ])
                        }
                    }
                }
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
                subject: "Resultado Paso a produccion: ${currentBuild.fullDisplayName}",
                body: "${env.BUILD_URL} has result ${currentBuild.currentResult}"
        }
    }
}
