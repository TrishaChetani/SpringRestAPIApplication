FROM openjdk:8-jdk-alpine 
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
ADD target/spring-mysql-*.jar app.jar 
ENV PORT 9090
EXPOSE 9090
ENTRYPOINT ["java","-jar","app.jar"]

