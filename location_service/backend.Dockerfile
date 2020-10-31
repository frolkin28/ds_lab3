FROM adoptopenjdk/openjdk11:alpine-jre

COPY . ./app

WORKDIR /app

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "./target/location_service.jar"]

