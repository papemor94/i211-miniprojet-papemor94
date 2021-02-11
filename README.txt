# command to execute the docker image 
docker run  -it --volume m2repos:/root/.m2 --publish 8091:8091 --volume src2:/services/src tug2 /bin/bash