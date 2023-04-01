FROM amazoncorretto:8-alpine-jdk 
MAINTAINER janetca 
COPY target/portfinal-0.0.1-SNAPSHOT.jar  portfinal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfinal-0.0.1-SNAPSHOT.jar"]