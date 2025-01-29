# Используем официальный образ для Java
FROM openjdk:17-jdk-slim

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл pom.xml и CSV файл в контейнер
COPY pom.xml .
COPY pp-2018.csv /app/pp-2018.csv

# Загружаем все зависимости с помощью Maven
RUN mvn dependency:resolve

# Копируем весь исходный код в контейнер
COPY src ./src

# Собираем приложение с помощью Maven
RUN mvn clean package -DskipTests

# Открываем порт, если приложение будет запускать сервер
EXPOSE 8080

# Устанавливаем команду для запуска JAR файла
CMD ["java", "-jar", "target/house-price-analysis-1.0-SNAPSHOT.jar"]
