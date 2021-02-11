# build stage

docker build -t imageName . 

# command to execute the docker image 
docker run --name containerName -it --volume m2repos:/root/.m2 --publish 8091:8091 --volume src2:/services/src imageName /bin/bash
