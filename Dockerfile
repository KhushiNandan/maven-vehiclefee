FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/VehicleParkingCalculator-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]