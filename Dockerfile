# Use an OpenJDK base image
FROM openjdk:11

# Set the working directory
WORKDIR /app

# Copy the Maven project files to the Docker image
COPY pom.xml /app
COPY src /app/src

# Use Maven to build the application inside the Docker container
# This will download dependencies, compile, and package the project
RUN apt-get update && \
    apt-get install -y maven && \
    mvn -f /app/pom.xml clean package

# Copy the generated JAR file to the Docker image
COPY target/StockTickerProject-1.0-SNAPSHOT.jar /app/StockTickerProject.jar

# Specify the command to run the application
CMD ["java", "-jar", "/app/StockTickerProject.jar"]
