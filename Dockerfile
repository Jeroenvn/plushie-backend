FROM maven:3-amazoncorretto-25-alpine AS build
WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


FROM amazoncorretto:25-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]