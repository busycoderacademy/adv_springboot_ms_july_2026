FROM eclipse-temurin:21-jdk
LABEL maintainer="rgupta.mtech@gmail.com"
EXPOSE 8080
ADD target/productappdb.jar productappdb.jar
ENTRYPOINT ["java","-jar","productappdb.jar"]