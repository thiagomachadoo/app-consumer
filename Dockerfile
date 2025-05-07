FROM openjdk:21-jdk

WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
