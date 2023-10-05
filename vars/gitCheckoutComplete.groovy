def call(String git_branch = "main", String git_crds = null, String git_url = null) {
    pipeline {
        agent { label 'slave1' }
        environment {
            GIT_BRANCH = "${git_branch}"
            GIT_CRDS = "${git_crds}"
            GIT_URL = "${git_url}"
        }
        stages {
            stage('git_checkout') {
                steps {
                    echo "starting SCM Checkout using gitCheckoutComplete.groovy file"
                    checkout([
                          $class: 'GitSCM', 
                          branches: [[name: "*/${GIT_BRANCH}"]], 
                          userRemoteConfigs: [[credentialsId: "${GIT_CRDS}", url: "${GIT_URL}"]]
                          ])
                    sh 'pwd; ls -lrt'
                }
            }
        }
    }

}