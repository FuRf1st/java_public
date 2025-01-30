# Используем официальный образ для JDK 21
FROM openjdk:21-jdk-slim

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл pom.xml в контейнер
COPY pom.xml .

# Загружаем все зависимости с помощью Maven
RUN mvn dependency:resolve

# Копируем весь исходный код в контейнер
COPY src ./src

# Собираем приложение с помощью Maven
RUN mvn clean package -DskipTests

# Открываем порт, если приложение будет запускать сервер
EXPOSE 8080

# Устанавливаем команду для запуска JAR файла
CMD ["java", "-jar", "target/prime-calculator-1.4.jar"]