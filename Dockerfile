FROM maven:3.9.4-eclipse-temurin-17 as build


COPY src src
COPY pom.xml pom.xml

RUN mvn clean package

FROM openjdk:17-jdk-alpine

RUN adduser --system assistant && addgroup --system assistant && adduser assistant assistant
USER assistant


WORKDIR /app

COPY --from=build target/recreation-assistant.jar ./recreation-assistant.jar
COPY --from=build target/dependency ./lib

VOLUME /data
ADD recreationAssistant.mv.db /data/recreationAssistant.mv.db

ENTRYPOINT ["java", "-cp", "./lib/*:./recreation-assistant.jar", "ru/recreation/recreationassistant/RecreationAssistantApplication"]