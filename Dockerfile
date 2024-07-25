FROM openjdk:21-jdk-slim-bookworm
ADD target/api-1.0-RELEASE.jar .
EXPOSE 8080
CMD ["java", "-jar", "api-1.0-RELEASE.jar"]