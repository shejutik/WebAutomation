pipeline {
    agent any

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }

    environment {
        // logical environment + URL of deployed portfolio site
        ENV      = 'prod'
        BASE_URL = 'https://shejutikhan.com'
    }

    stages {

        stage('Checkout Automation Project') {
            steps {
                echo "Checking out automation repo..."
                checkout scm
            }
        }

        stage('Run Maven TestNG Suite') {
            steps {
                echo "Running automated tests with Maven & TestNG..."
                // Use the same command as on your laptop, plus baseUrl if you want
                sh "mvn clean test -Denv=${ENV} -DbaseUrl=${BASE_URL}"
                // If you do not yet read baseUrl in your framework, this is still safe;
                // your code will just ignore it.
            }
        }

        stage('Publish Test Reports') {
            steps {
                echo "Publishing test reports..."

                junit allowEmptyResults: true,
                      testResults: 'target/surefire-reports/*.xml'

                archiveArtifacts artifacts: 'target/surefire-reports/**',
                                  fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Automation tests PASSED.'
        }
        unstable {
            echo '⚠️ Tests are UNSTABLE (some failed or flaky). Check the report.'
        }
        failure {
            echo '❌ Automation tests FAILED. Investigate failures in the report.'
        }
    }
}
