#!/bin/sh
# default settings
mode='normal'

# extract param from instructions
while getopts "m:" OPT
do
    case $OPT in
        m)
            mode=$OPTARG
            ;;
    esac
done

# waiting for SonarQube connection
while ! nc -z sonarqube 9000;
    do
        echo 'waiting for SonarQube Connection';
        sleep 5;
    done;
echo SonarQube Connected!;

# analyzing the project using SonarQube
mvn org.jacoco:jacoco-maven-plugin:prepare-agent install

if [ $mode == 'normal' ]; then
    mvn sonar:sonar

elif [ $mode == 'container' ]; then
    mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000
fi