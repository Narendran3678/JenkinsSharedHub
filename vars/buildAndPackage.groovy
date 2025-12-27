def call(Map config) {
    node {
        echo "Maven Build Started...${config.projectName}"
        dir(${config.projectName}) {
            bat '''
            cd ${projectName}
            mvn clean install -DskipTests=true versions:set -DnewVersion='%version%' versions:update-child-modules
            '''
        }
    }
}
