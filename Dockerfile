
FROM openjdk:17-jdk-slim


WORKDIR /AssuranceAppSecurity


COPY target/AssuranceAppSecurity.jar /AssuranceAppSecurity.jar


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "AssuranceAppSecurity.jar"]
