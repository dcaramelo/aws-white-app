FROM maven:3.5-jdk-8-alpine as build
RUN mkdir -p /app
COPY . /app
WORKDIR /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build target/aws-white-app-1.0-SNAPSHOT.jar /app
CMD ["java -jar aws-white-app-1.0-SNAPSHOT.jar"]

