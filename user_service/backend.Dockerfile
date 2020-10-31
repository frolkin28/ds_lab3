FROM adoptopenjdk/openjdk11:alpine-jre

COPY . ./app

WORKDIR /app

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "./target/user_service.jar"]

