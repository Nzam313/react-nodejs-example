
def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t nzam/demo-app:3.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push nzam/demo-app:3.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
