#!/usr/bin/env groovy
def call(){
    echo 'Building Image'
    
    withCredentials([usernamePassword(credentialsId: 'docker-hub',passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t izuku11/demo-app:notifcations-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push izuku11/demo-app:notifcations-2.0'
        }      
}