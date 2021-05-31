Ceci est un mini projet qui a pour but de mettre en oeuvre les connaissances dans les technologies suivantes:
- **JPA** (dont l'implémentation de référence Hibernate)
- **Restful** (  Jersey et Grizzly)
- **Git**
- **Docker** ( create image with Dockerfile, build and orckestration with docker-compose)

## Executer sous docker  : 
- configurer mysql dans le fichier persistence.xml
- lancer la commande **docker build -t miniproj .**
- puis : **docker-compose up** pour lancer l'application sous docker
## REST Client
 Une fois l'application lancée, veuillez bien faire un premier GET de **http://127.0.0.1:8091/bibliotheque/init **  pour initiliser la base de données qui est vide par défaut.
