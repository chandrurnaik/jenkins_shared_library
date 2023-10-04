def call(String git_branch = "main", String git_crds = null, String git_url = null) {
     echo "Starting SCM Checkout gitCheckout.groovy"
     checkout([
        $class: 'GitSCM', 
        branches: [[name: "*/${git_branch}"]], 
        userRemoteConfigs: [[credentialsId: "${git_crds}", url: "${git_url}"]]
    ])
    sh 'pwd; ls -lrt'
}