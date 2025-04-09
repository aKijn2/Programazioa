# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/notak.jar /app/notak.jar

# Expose the port your application will run on (if applicable)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "notak.jar"]