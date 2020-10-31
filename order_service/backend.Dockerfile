FROM adoptopenjdk/openjdk11:alpine-jre

COPY . ./app

WORKDIR /app

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "./target/order_service.jar"]