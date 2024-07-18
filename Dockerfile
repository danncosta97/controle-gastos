FROM openjdk:21-jdk-slim
COPY target/controle-gastos-1.0-SNAPSHOT-jar-with-dependencies.jar /controle-gastos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/controle-gastos.jar"]