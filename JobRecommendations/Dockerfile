FROM maven:3.8.5-openjdk-17-slim AS build
RUN ls
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM amazoncorretto:17.0.3
COPY --from=build /home/app/target/JobRecommendations-0.0.1-SNAPSHOT.jar /usr/local/lib/JobRecommendations-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/JobRecommendations-0.0.1-SNAPSHOT.jar"]