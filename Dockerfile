# Step 1: Build the code using regular maven
FROM maven:3.9.2-eclipse-temurin-17 as maven
COPY pom.xml /home/app/
WORKDIR /home/app
RUN mvn verify -B --fail-never
COPY src /home/app/src
RUN mvn package -Dquarkus.package.type=native-sources

# Stage 2: Build the native image
FROM quay.io/quarkus/ubi-quarkus-mandrel:22.3-java17 AS native-build
COPY --chown=quarkus:quarkus --from=maven /home/app/target/native-sources /build
USER quarkus
WORKDIR /build
RUN native-image $(cat native-image.args) -J-Xmx4g

# Stage 3: Create the docker final image
FROM quay.io/quarkus/quarkus-micro-image:2.0
WORKDIR /work/
COPY --from=native-build /build/*-runner /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]