# create your custom drupal image here, based of official drupal
FROM maven:3.6.0-jdk-8-alpine

WORKDIR /root/springboot-template

EXPOSE 8080:8080

VOLUME /root/.m2

CMD mvn package && /bin/sh