FROM openjdk:8

ADD target/api_hobeez-1.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
