#!/usr/bin/env groovy
package com.example

class Docker implements Serializable{
    def script //used to stores all variable available in Jenkinsfile
    
    Docker(script){
        this.script=script
    }

    def buildDockerImage(String imageName) {
        script.echo 'Building Image'
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub',passwordVariable: 'PASS', usernameVariable: 'USER')]){
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
            script.sh "docker push $imageName"
            }    
        }
    }
