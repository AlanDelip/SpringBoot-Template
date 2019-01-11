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



pid=`ps -def | grep 'java.*active='$profile'.*SpringBootTmpl-LATEST.jar.*' | grep -v grep | awk '{print $2}'`
kill $pid;

sh tool/start-server.sh -p $profile -m $mode
