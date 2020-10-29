FROM postgres:11

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=location_service_db

EXPOSE 5434

CMD ["-p", "5434"]