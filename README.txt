# build stage

docker build -t imagename . 

# command to execute the docker image 
docker run --name containername -it --volume m2repos:/root/.m2 --publish 8091:8091 --volume src2:/services/src imagename /bin/bash
