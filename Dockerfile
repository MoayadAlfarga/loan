# Use Java 21 runtime
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy jar file into container
COPY target/loan-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot port (from application.yaml)
EXPOSE 8091

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]