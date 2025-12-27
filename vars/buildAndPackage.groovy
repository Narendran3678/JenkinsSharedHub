def call(Map config) {
    node {
        echo "${config.projectName}"
        bat '''
        cd %config.projectName%
        mvn clean install -DskipTests=true versions:set -DnewVersion='%version%' versions:update-child-modules
        '''
    }
}
