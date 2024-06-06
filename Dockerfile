FROM openjdk:17 as builder

LABEL author=kelvin.cardenas

COPY target/app-tipocambio-0.0.1-SNAPSHOT.jar app.jar
EXPOSE:8080
CMD ["java", "-jar", "app.jar"]
