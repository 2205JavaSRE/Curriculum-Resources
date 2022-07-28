#!/bin/bash 


#Jenkins will pull the code from github, build the code, test it, package it, deploy it. 

#git pull 

echo 'this is where I would do a git pull'

#Switching to the directory with the pom.xml 


#maven compile step 

echo 'Compiling the source code' 

mvn compile 

#maven test step 

echo 'Testing the source code'

mvn test 

#maven package step 

echo 'packing the source code into a JAR file'

mvn package 

#publishing the jar file onto DockerHub

#Deploying the JAR file