# Multi Stage build

# Base Image and name stage as "builder"
FROM maven:3-openjdk-15 AS builder

#mvn -f pom.xml clean package  -DskipTests

FROM openjdk:15.0.1

WORKDIR /Hospital_Management-main/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY /target/springboot-0.0.1-SNAPSHOT.jar ./sb-dockerized.jar

# Expose the port to the inner container communication network
EXPOSE 3100

# Run the Java Application
ENTRYPOINT [ "java","-jar","/Hospital_Management-main/lib/sb-dockerized.jar"]