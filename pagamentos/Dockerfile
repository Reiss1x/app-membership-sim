FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw clean install -DskipTests
FROM eclipse-temurin:21-jre-alpine AS final
WORKDIR /workspace/app
COPY --from=build /workspace/app/target/*.jar /workspace/app/app.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "/workspace/app/app.jar"]