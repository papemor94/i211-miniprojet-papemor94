FROM maven:3.5.4-jdk-8-alpine as maven
COPY pom.xml /services/pom.xml
COPY mvn-entrypoint.sh /services/mvn-entrypoint.sh
COPY /src /services/src
WORKDIR /services
RUN mvn clean compile
ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]