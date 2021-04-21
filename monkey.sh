 #!bin/bash

ls_rootdir="/mnt/sdcard/monkey"
if [ ! -d $ls_rootdir  ];then
  mkdir $ls_rootdir
fi

ls_date=$(date "+%Y-%m-%d")
ls_daymonkeydir="$ls_rootdir/$ls_date"
if [ ! -d $ls_daymonkeydir  ];then
  mkdir $ls_daymonkeydir
fi

ls_datetime=$(date "+%Y-%m-%d_%H-%M")

ls_errorpath="$ls_daymonkeydir/${ls_datetime}error.txt"
ls_infopath="$ls_daymonkeydir/${ls_datetime}info.txt"
#logcat_file="monkey/${ls_datetime}logcat.txt"

packagename="com.dream.create"
#category="com.kingsoft.monkey"

#PID=$(ps -ef | grep $packagename | grep -v grep | awk '{print $2}')
#echo "email pid->$PID"

versionInfo=$(dumpsys package $packagename | grep version)
echo "com.dream.create info:"
echo "$versionInfo"

#monkey -p ${packagename} -c ${category} --ignore-crashes --ignore-timeouts --ignore-native-crashes --monitor-native-crashes --pct-motion 20 --pct-nav 20 --pct-majornav 15 --pct-appswitch 5 --pct-anyevent 5 --pct-trackball 0 --pct-syskeys 0  --pct-touch 30  -v -v -v --throttle 300 10000000 2>/mnt/sdcard/${ls_errorpath} 1>/mnt/sdcard/${ls_infopath} &

monkey -p ${packagename} -c android.intent.category.MONKEY --ignore-crashes --ignore-timeouts --ignore-native-crashes --monitor-native-crashes --pct-motion 20 --pct-nav 20 --pct-majornav 15 --pct-appswitch 5 --pct-anyevent 5 --pct-trackball 0 --pct-syskeys 0  --pct-touch 30  -v -v -v --throttle 300 10000000 2>${ls_errorpath} 1>${ls_infopath} &
echo "monkey started , Output folder is ${ls_daymonkeydir}"

#logcat -v time  | grep $packagename >/mnt/sdcard/${logcat_file} &

#echo "logcat started"

