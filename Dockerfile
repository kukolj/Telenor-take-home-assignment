FROM openjdk:8
ADD target/andrija-0.0.1-SNAPSHOT.jar andrija-docker.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/andrija-docker.jar"]