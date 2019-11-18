FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B
COPY src src







