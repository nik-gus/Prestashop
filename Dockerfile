FROM openjdk:8
COPY ./src/test/java/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","TestRunner"]