pipeline {
    agent any

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }

    environment {
        // Point your tests to the deployed portfolio site
        BASE_URL = 'https://your-portfolio-domain.com'   // <-- change this
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
                // If your framework reads baseUrl from a system property, use this:
                sh 'mvn clean test -DbaseUrl=${BASE_URL}'
                // If not, simple:
                // sh 'mvn clean test'
            }
        }

        stage('Publish Test Reports') {
            steps {
                echo "Publishing test reports..."

                // JUnit-style XML (Surefire / TestNG via surefire)
                junit allowEmptyResults: true,
                      testResults: 'target/surefire-reports/*.xml'

                // Optional: archive the full report folder
                archiveArtifacts artifacts: 'target/surefire-reports/**',
                                  fingerprint: true
            }
        }
    }

    post {
        success {
            echo "✅ Automation tests PASSED."
        }
        unstable {
            echo "⚠️ Tests are UNSTABLE (some failed or flaky). Check the report."
        }
        failure {
            echo "❌ Automation tests FAILED. Investigate failures in the report."
        }
    }
}
