#!/usr/bin/env bash
profile='dev'

while getopts "p:" OPT; do
    case $OPT in
        p)
            profile=$OPTARG
            ;;
    esac
done


pid=`ps -def | grep 'java.*active='$profile'.*SpringBootTmpl-LATEST.jar.*' | grep -v grep | awk '{print $2}'`
kill $pid;

sh tool/start-server.sh -p $profile
