FROM openjdk:17-alpine
WORKDIR /app
COPY target/crud.jar /app/crud.jar
CMD ["java", "-jar", "crud.jar"]
