FROM openjdk:14-alpine
COPY build/libs/Bitrack-*-all.jar Bitrack.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "Bitrack.jar"]