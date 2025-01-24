package com;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {

        // Запросить путь к файлу у пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к JSON-файлу с заказами: ");
        String filePath = scanner.nextLine();

        // Загрузка заказов из JSON-файла
        List<Order> orders = loadOrdersFromJsonFile(filePath);

        if (orders == null) {
            System.err.println("Не удалось загрузить заказы из файла.");
            return;
        }

        // Фильтрация заказов за февраль 2020 года
        LocalDate startDate = LocalDate.of(2020, 2, 1);
        LocalDate endDate = LocalDate.of(2020, 2, 29);
        List<Order> februaryOrders = orders.stream()
                .filter(order -> order.getOrderDate() != null &&
                        !order.getOrderDate().isBefore(startDate) &&
                        !order.getOrderDate().isAfter(endDate))
                .collect(Collectors.toList());

        // Расчет общей суммы заказов
        double totalSum = februaryOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();

        // Вывод результата
        System.out.println("Общая сумма всех заказов, размещённых в феврале 2020 года: " + totalSum);
    }

    // Метод для загрузки данных о заказах из JSON-файла
    private static List<Order> loadOrdersFromJsonFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Регистрация модуля для работы с Java 8 LocalDate
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        try {

            // Читаем JSON из файла
            File file = new File(filePath);
            // Преобразуем JSON в список Order
            return objectMapper.readValue(file, new TypeReference<List<Order>>() {});
        } 
        catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }
}
