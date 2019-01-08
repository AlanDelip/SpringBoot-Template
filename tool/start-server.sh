#!/usr/bin/env bash
profile='dev'

while getopts "p:" OPT; do
    case $OPT in
        p)
            profile=$OPTARG
            ;;
    esac
done

mvn package

##deploy
java -jar -Dspring.profiles.active=$profile target/SpringBootTmpl-LATEST.jar > run.log &
