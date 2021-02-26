## PapeJDBC 

#  Utilisez ces commandes pour lancer le container de l'application et la base de donnees postgresql 

# Pour la persitence des données , j'utilise une image postgresql, les details de l'utilsation sont clairement expliqués sur dockerhub

docker run -it --rm -d \
    --name postgres1 \
    -e POSTGRES_PASSWORD=mysecretpassword \
    -e POSTGRES_USER=postgres \
    -p 5432:5432 \
    -v data-jdbc-simple-docker-pg1:/var/lib/postgresql/data \
    postgres:12.2-alpine

# Avec le Dockerfie , je construis l'image de mon application Java  : celui ci contientun fichier jar executable contenant toutes les dependances( outils de build  : Maven )

docker build -t monappimage .

# Lancement du conteneur avec docker run 
docker run -it --rm --name appcontainer --volume m2repos:/root/.m2 --publish 8091:8091 --volume src2:/services/sr --link postgres1 monappimage 

