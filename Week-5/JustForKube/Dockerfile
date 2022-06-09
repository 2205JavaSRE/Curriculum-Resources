#Building stage, to build the jar file
#I require a Maven image to be able to build a maven project!

FROM maven:3.8.5-openjdk-8 AS MAVEN_BUILD_STAGE

#Copy over all the files inside of our directory!
COPY ./ ./

RUN mvn clean package


#Distributable lightweight image for running the jar file
FROM openjdk:8-jre

COPY --from=MAVEN_BUILD_STAGE /target/JustForKube-0.0.1-SNAPSHOT-jar-with-dependencies.jar /random/folder/demo.jar


CMD ["java","-jar","/random/folder/demo.jar"]
