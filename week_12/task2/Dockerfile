# Шаг 1: Используем образ с Maven и JDK для сборки
FROM maven:3.8.6 AS build

# Копируем файлы проекта в контейнер
WORKDIR /app
COPY . /app

# Выполняем сборку с помощью Maven
RUN mvn clean package

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Шаг 2: Используем образ с JDK для запуска
FROM openjdk:17-jdk-slim

# Копируем собранный JAR файл из предыдущего шага
WORKDIR /app
COPY --from=build /app/target/house-price-analysis-1.0-SNAPSHOT.jar /app/house-price-analysis.jar

# Команда для запуска JAR файла
CMD ["java", "-jar", "/app/house-price-analysis.jar"]

# Скопировать CSV файл в контейнер
COPY D:\\pp-2018.csv /app/pp-2018.csv
