FROM alpine:latest

ADD sayhello /sayhello
RUN chmod +x /sayhello

RUN apk add --no-cache openssl
ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

CMD ["/sayhello"]

FROM openjdk:8
COPY ./target/trips-0.0.1-SNAPSHOT.jar trips-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","trips-0.0.1-SNAPSHOT.jar"]