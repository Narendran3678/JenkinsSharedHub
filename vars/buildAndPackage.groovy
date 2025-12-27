def call(Map config) {
    node {
        echo "Maven Build Started...${config.projectName}"
        bat """
        dir
        cd ${config.projectName}
        mvn clean install -DskipTests=true versions:set -DnewVersion='%version%' versions:update-child-modules
        """
    }
}
