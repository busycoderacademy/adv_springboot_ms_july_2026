FROM eclipse-temurin:21-jdk
LABEL maintainer="rgupta.mtech@gmail.com"
EXPOSE 8090
ADD target/productapp.jar productapp.jar
ENTRYPOINT ["java","-jar","/productapp.jar"]