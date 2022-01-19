FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/user-0.0.1-SNAPSHOT.jar user.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar","user.jar"]