FROM openjdk
ADD target/gateway-1.0.jar gateway-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway-1.0.jar"]
