FROM maven:3.5-jdk-8-alpine as build
RUN mkdir -p /app
COPY . /app
WORKDIR /app
RUN mvn install

FROM openjdk:8-jre-alpine

LABEL author="David Caramelo"
MAINTAINER david.caramelo83@gmail.com

WORKDIR /app
COPY --from=build /app/target/aws-white-app-1.0-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "aws-white-app-1.0-SNAPSHOT.jar"]

