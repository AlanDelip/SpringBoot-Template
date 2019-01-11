#!/bin/sh
# waiting for SonarQube connection
while ! nc -z sonarqube 9000;
    do
        echo 'waiting for SonarQube connection';
        sleep 5;
    done;
echo SonarQube Connected!;

# analyzing the project using SonarQube
mvn org.jacoco:jacoco-maven-plugin:prepare-agent install
mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000