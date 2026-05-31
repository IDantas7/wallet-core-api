FROM eclipse-temurin:21-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/wallet-core-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} wallet.jar
ENTRYPOINT ["java", "-jar", "wallet.jar"]
