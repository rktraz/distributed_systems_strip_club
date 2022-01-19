FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/appointment-0.0.1-SNAPSHOT.jar appointment.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar","appointment.jar"]