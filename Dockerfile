# AS <NAME> to name this stage as maven
FROM maven:3.6.3 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app

RUN mvn package -DskipTests

# For Java 11,
FROM adoptopenjdk/openjdk15:jdk-15.0.2_7-alpine

ARG JAR_FILE=msg-user-service.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","msg-user-service.jar"]

EXPOSE 62461