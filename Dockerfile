FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} smart-host-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/smart-host-0.0.1-SNAPSHOT.jar"]