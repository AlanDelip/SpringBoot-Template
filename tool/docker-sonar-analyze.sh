#!/bin/sh
mode="normal"

# extract param from instructions
while getopts "m:" OPT
do
    case $OPT in
        m)
            mode=$OPTARG
            ;;
    esac
done

if [ $mode == 'normal' ]; then
    docker exec springboot-template_springboot_1 sh tool/sonar-analyze.sh -m container

elif [ $mode == 'silent' ]; then
    docker exec -d springboot-template_springboot_1 sh tool/sonar-analyze.sh -m container

elif [ $mode == 'interactive' ]; then
    docker exec -it springboot-template_springboot_1 bash

fi