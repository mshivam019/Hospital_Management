FROM openjdk:17-jdk-slim

WORKDIR /Hospital_Management-main/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY /target/springboot-0.0.1-SNAPSHOT.jar ./sb-dockerized.jar

# Expose the port to the inner container communication network
EXPOSE 80

# Run the Java Application
ENTRYPOINT [ "java","-jar","/Hospital_Management-main/lib/sb-dockerized.jar"]
