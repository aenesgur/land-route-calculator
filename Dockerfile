FROM adoptopenjdk/openjdk11
EXPOSE 8080
ARG JAR_FILE=target/land-route-calculator-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]

