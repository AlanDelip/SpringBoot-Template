#!/bin/sh
profile='dev'
mode='silent'

while getopts "p:m:" OPT
do
    case $OPT in
        p)
            profile=$OPTARG
            ;;
        m)
            mode=$OPTARG
            ;;
    esac
done

mvn clean
mvn package

##deploy
if [ $mode == 'silent' ]; then
    java -jar -Dspring.profiles.active=$profile target/SpringBootTmpl-LATEST.jar > run.log &

elif [ $mode == 'normal' ]; then
    java -jar -Dspring.profiles.active=$profile target/SpringBootTmpl-LATEST.jar

elif [ $mode == 'container' ]; then
    # waiting for the database connection
    while ! nc -z database 3306;
        do
            echo 'waiting for the database connection';
            sleep 1;
        done;
    echo Database Connected!;

    # run the built springboot project
    java -jar -Dspring.profiles.active=$profile target/SpringBootTmpl-LATEST.jar > run.log &

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
fi

/bin/bash