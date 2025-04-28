# Normal
# empaquetar: mvnw clean package
FROM eclipse-temurin:17-alpine
COPY target/DevOps-0.0.1-SNAPSHOT.jar /usr/app.jar
ENTRYPOINT ["java","-cp","/usr/app.jar","com.gildedrose.App"]

# crear imagen: docker build -t demos-devops .
# crear contenedor: docker run -rm --name demos-devops demos-devops
