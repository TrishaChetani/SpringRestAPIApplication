FROM openjdk:8-jdk-alpine 
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
ADD target/spring-mysql-*.jar app.jar 
ENTRYPOINT ["java","-jar","app.jar"]


