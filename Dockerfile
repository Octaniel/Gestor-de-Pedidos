FROM adoptopenjdk/openjdk8:ubi

EXPOSE 8080

ADD target/gestorpedidos.jar gestorpedidos.jar

ENTRYPOINT ["java", "-jar", "gestorpedidos.jar"]

