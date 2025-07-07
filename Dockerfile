FROM eclipse-temurin:17-jdk-alpine

# Define pasta de trabalho
WORKDIR /app

# Copia o JAR gerado pelo Maven
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expõe a porta padrão
EXPOSE 8080

# Executa o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
