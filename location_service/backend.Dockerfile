FROM adoptopenjdk/openjdk11:alpine-jre

COPY . ./app

WORKDIR /app

ENV API_SECRET_KEY = my_secret_key
ENV USER_SERVICE_DOMAIN = user-service:8081
ENV CAR_SERVICE_DOMAIN = car-service:8082
ENV LOCATION_SERVICE_DOMAIN = location-service:8083
ENV ORDER_SERVICE_DOMAIN = order-service:8084

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "./target/location_service.jar"]

