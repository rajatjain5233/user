FROM openjdk:17-jdk-slim

EXPOSE 8081

RUN apt-get update && apt-get install -y default-mysql-client

ADD target/user.jar user.jar

ENTRYPOINT ["java","-jar","user.jar"]