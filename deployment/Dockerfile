FROM openjdk
ADD k8s-seamless-1.0-SNAPSHOT.jar /tmp/app/app.jar
WORKDIR /tmp/app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
