FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD service1-1.0-SNAPSHOT.jar service1.jar
RUN sh -c 'touch /service1.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /service1.jar" ] 
