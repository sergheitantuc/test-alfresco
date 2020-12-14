call mvn install -DskipTests
docker build --tag fizzbuzzapi:1.0 .
docker run --publish 8333:8333 --detach fizzbuzzapi:1.0