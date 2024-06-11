FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17
COPY --from=build ./target/*.jar notepadA.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "notepadA.jar"]