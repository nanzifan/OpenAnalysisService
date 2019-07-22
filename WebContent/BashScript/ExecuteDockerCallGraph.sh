#echo "I'm executed"
#DIR=$(pwd)
#echo "${DIR}"
(sudo docker exec $1 /usr/share/profile_gprof.sh cpuload.cpp) &> "$2/out_$1.txt"
echo "$2/out_$1.txt"
cat $2/out_$1.txt
#sudo docker exec -it $1 /usr/share/profile_gprof.sh cpuload.cpp
