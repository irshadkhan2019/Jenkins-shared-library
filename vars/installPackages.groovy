#!/usr/bin/env groovy
def call(){

     echo "Installing package for branch $BRANCH_NAME"
     sh 'npm install'
         
}