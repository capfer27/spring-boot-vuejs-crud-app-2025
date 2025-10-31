# Stage 1: Build the Spring Boot application using Gradle
#FROM gradle:9-jdk21 AS build
#WORKDIR /app
#COPY . .
##RUN gradle bootJar

# Stage 2: Create the final image with a JRE and the application JAR
#FROM openjdk:21
#WORKDIR /app
#COPY --from=build /app/build/libs/*.jar /app/spring-boot-vue-crud.jar
#EXPOSE 18080
#ENTRYPOINT ["java", "-jar", "/app/spring-boot-vue-crud.jar"]

FROM openjdk:21-jdk
LABEL maintainer="capfer27@gmail.com"
LABEL version="0.0.1-SNAPSHOT"
LABEL description="Java Spring Boot Vue JS CRUD application"
WORKDIR /app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/spring-boot-vue-crud.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-boot-vue-crud.jar"]
