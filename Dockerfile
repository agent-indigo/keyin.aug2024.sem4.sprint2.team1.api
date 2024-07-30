FROM eclipse-temurin:21
COPY target/*.jar ./bark-api.jar
EXPOSE 8080
CMD ["java", "-jar", "bark-api.jar"]