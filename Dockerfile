FROM openjdk:17-alpine3.14
COPY target/restaurant-service.jar restaurant-service.jar
ENTRYPOINT ["java", "-jar", "/restaurant-service.jar"]