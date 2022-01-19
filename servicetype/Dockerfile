FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/servicetype-0.0.1-SNAPSHOT.jar servicetype.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar","servicetype.jar"]