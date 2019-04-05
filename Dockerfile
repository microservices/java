FROM 		maven:3-jdk-8 as builder
RUN         mkdir /java
WORKDIR		/java
COPY		pom.xml /java
# download all dependencies
RUN			mvn install && mvn package
# copy over all source files and build a standalone jar
COPY        src /java/src/
RUN			mvn package

FROM        java:8-jre-alpine
WORKDIR		/app
COPY 		--from=builder /java/target/omg-template-java.jar .
COPY 		--from=builder /java/target/omg-template-java.lib omg-template-java.lib
ENTRYPOINT  ["java", "-jar", "/app/omg-template-java.jar"]
