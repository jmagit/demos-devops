# Normal
# empaquetar: mvnw clean package
FROM eclipse-temurin:17-alpine
COPY demos-devops/target/DevOps-0.0.1-SNAPSHOT.jar /usr/app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/usr/app.jar"]

# crear imagen: docker build -t demos-devops .
# crear contenedor: docker run -d --name demos-devops demos-devops
# añadir a red: docker network connect microservicios demos-devops
