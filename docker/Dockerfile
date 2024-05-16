FROM maven:3.8.1-openjdk-17 AS builder

WORKDIR /app

RUN git clone https://github.com/AvdIlay/SmartDeltaSystems.git .

RUN mvn clean package -DskipTests

FROM openjdk:17

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]