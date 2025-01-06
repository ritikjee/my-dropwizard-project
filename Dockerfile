# Step 1: Build the application
FROM maven:3.8.7-eclipse-temurin-21 AS build

# Set the working directory in the build container
WORKDIR /app

# Copy the Maven project files into the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Step 2: Create the runtime image
FROM eclipse-temurin:21-jre

# Set the working directory in the runtime container
WORKDIR /app

# Copy the built JAR file and configuration file from the build step
COPY --from=build /app/target/MyDropwizardProject-1.0-SNAPSHOT.jar app.jar
COPY config.yml config.yml

# Expose port 8080 for the application
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar", "server", "config.yml"]
