# Use a lightweight base image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the WAR file into the container
COPY ./target/KubeTest-0.0.1-SNAPSHOT.war /app/KubeTest-0.0.1-SNAPSHOT.war

# Copy the MySQL Connector JAR into the container (Commented out)
# COPY ./mysql-connector-java-8.0.28/mysql-connector-java-8.0.28.jar /app/mysql-connector-java.jar

# Expose the port that your application runs on
EXPOSE 8080

# Optionally, specify environment variables if needed (Commented out)
# ENV MYSQL_HOST=mysql-container-name
# ENV MYSQL_PORT=3306

# Specify the command to run when the container starts
CMD ["java", "-jar", "KubeTest-0.0.1-SNAPSHOT.war"]