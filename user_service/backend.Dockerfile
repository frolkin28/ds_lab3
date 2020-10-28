FROM adoptopenjdk/openjdk11:alpine-jre

COPY . ./app

WORKDIR /app

ENTRYPOINT ["java", "-jar", "./target/user_service.jar"]

