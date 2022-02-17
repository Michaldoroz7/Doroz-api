
FROM maven:3.6.1-jdk-11
MAINTAINER doroz
COPY target/RestApi-0.0.1-SNAPSHOT.jar /Restapi-0.0.1.jar
ENTRYPOINT ["java","-jar","Restapi-0.0.1.jar"]