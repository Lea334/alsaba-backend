#
# Build stage
#
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM eclipse-temurin:17-alpine
COPY --from=build /target/backend-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
# EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]