FROM openjdk:8

ADD target/api_hobeez-2.1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
