FROM fabric8/java-centos-openjdk11-jre:latest

EXPOSE 8333

COPY target/FizzBuzz*.jar .

CMD java -jar *.jar