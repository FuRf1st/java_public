package com;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Используем Scanner для ввода пути к файлу с клавиатуры
        Scanner scanner = new Scanner(System.in);
        
        // Запрашиваем путь к файлу у пользователя
        System.out.print("Введите путь к CSV файлу: ");
        String filePath = scanner.nextLine(); // Считываем введенный путь
        
        // Закрываем сканер, чтобы избежать утечек ресурсов
        scanner.close();
        
        try {
            // Чтение данных из CSV
            List<HouseData> data = CSVReader.readData(filePath);

            // Параллельная обработка данных
            Map<Integer, Map<String, Double>> processedData = DataProcessor.processDataParallel(data);

            // Показ гистограммы
            ChartGenerator.showHistogram(processedData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
