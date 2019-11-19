FROM openjdk:8-jdk-alpine 
ADD target/spring-mysql-*.jar app.jar 
ENTRYPOINT ["java","-jar","app.jar"]


