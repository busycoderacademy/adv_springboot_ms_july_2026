FROM eclipse-temurin:21-jdk
LABEL maintainer="rgupta.mtech@gmail.com"
EXPOSE 8081
ADD target/productapp-client.jar productapp-client.jar
ENTRYPOINT ["java","-jar","productapp-client.jar"]