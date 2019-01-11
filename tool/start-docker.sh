#!/bin/sh
mode='normal'

while getopts "m:" OPT
do
    case $OPT in
        m)
            mode=$OPTARG
            ;;
    esac
done

docker-compose down

if [ $mode == 'normal' ]; then
    docker-compose up

elif [ $mode == 'silent' ]; then
    docker-compose up -d

fi
