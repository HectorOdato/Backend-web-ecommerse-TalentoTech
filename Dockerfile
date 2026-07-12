FROM eclipse-temurin:25-jdk-jammy AS build
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV PORT 8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
