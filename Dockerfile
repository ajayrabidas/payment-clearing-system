#FROM eclipse-temurin:8
FROM eclipse-temurin:17-jdk

#COPY target/payment-system.jar app.jar
COPY target/payment-system-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]