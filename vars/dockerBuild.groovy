def call(String dockerfile = null,
         String docker_context = null,
         String image_name = null,
         String image_tag = null,
         String registry_url = null,
         String registry_crds = null) {
    def customImage = docker.build("${image_name}:${image_tag}",
                                   "-f ${dockerfile} ${docker_context}")
    docker.withRegistry("${registry_url}", "${registry_crds}") {

        customImage.push()
    }
}