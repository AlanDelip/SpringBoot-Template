#!/bin/sh
# default settings
profile='dev'
mode='silent'

# extract param from instructions
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

# maven clean & package
mvn clean
mvn package

# deploy
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
    java -jar -Dspring.profiles.active=$profile target/SpringBootTmpl-LATEST.jar
fi