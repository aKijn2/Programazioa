# OpenJDK oinarritutako irudia erabili
FROM openjdk:17-jdk-slim

# Laneko direktorioa ezarri
WORKDIR /app

# Konpilatutako JAR fitxategia kontainerrera kopiatu
COPY target/notak.jar /app/notak.jar

# Aplikazioa exekutatuko den portua exposeatu (beharrezkoa bada)
EXPOSE 8080

# Aplikazioa exekutatzeko komandoa
CMD ["java", "-jar", "notak.jar"]