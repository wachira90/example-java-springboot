# Stage 1: Build the application
# FROM maven:3.9.4-eclipse-temurin-17 AS build
FROM public.ecr.aws/docker/library/maven:3.9.0-eclipse-temurin-8-alpine AS build

# Set working directory in the container
WORKDIR /app

# Copy the Maven project files
# COPY pom.xml ./
# COPY src ./src

COPY . .

# Build the project and create the executable JAR
# RUN mvn clean package -DskipTests
RUN mvn clean install -DskipTests

# Stage 2: Create a lightweight runtime image
FROM eclipse-temurin:17-jre-alpine

# Set working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
