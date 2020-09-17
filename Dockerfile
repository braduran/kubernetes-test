FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8087
ADD build/*.jar app.jar
ENTRYPOINT java -jar -Duser.timezone="America/Bogota" app.jar