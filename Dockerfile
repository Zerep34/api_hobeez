FROM openjdk:8

ADD target/go_style-2.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
