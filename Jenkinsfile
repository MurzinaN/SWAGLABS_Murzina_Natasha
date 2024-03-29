pipeline {
    agent any
      triggers {
            cron('0 12 * * *')
        }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3"
    }

    parameters {
     gitParameter branchFilter: 'origin/(.*)', defaultValue: 'main', name: 'BRANCH', type: 'PT_BRANCH'
     choice(name: 'SUITE_NAME', choices: ['smokeTest.xml', 'negativeTest.xml', 'regressionTest.xml'], description: 'Choice suiteXmlFile')
     choice(name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Choice browser')
    }

  stages {
        stage('Run tests') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/MurzinaN/SWAGLABS_Murzina_Natasha.git'

                // Run Maven on a Unix agent.
               bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlFile=${params.SUITE_NAME} -Dbrowser=${params.BROWSER} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }

    }
}