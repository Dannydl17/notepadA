FROM maven:3:8:7 as build
COPY . .
RUN mvn -B clean package -DskipTests
FROM openjdk:17
COPY --from=build ./target/*.jar notepadA.jar
EXPOSE PORT = 8181
ENTRYPOINT ["java", "-jar", "notepadA.jar"]