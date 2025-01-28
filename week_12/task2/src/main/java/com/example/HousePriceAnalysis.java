package com.example;

import org.tinylog.Logger;

public class HousePriceAnalysis {

    public static void main(String[] args) {
        if (args.length == 0) {
            Logger.error("Please provide the path to the dataset as a command line argument.");
            return;
        }
    
        String datasetPath = args[0];  // Путь к файлу датасета
        Logger.info("Loading dataset from: {}", datasetPath);
    
        // Дальше идет остальной код
    
        try {
            // Загрузка данных
            DataLoader dataLoader = new DataLoader();
            var records = dataLoader.loadData(datasetPath);

            // Обработка данных
            DataProcessor dataProcessor = new DataProcessor();
            var cityYearMaxPrice = dataProcessor.calculateMaxPricesByCityAndYear(records);

            // Визуализация данных
            ChartVisualizer visualizer = new ChartVisualizer();
            visualizer.displayCharts(cityYearMaxPrice);

        } catch (Exception e) {
            Logger.error(e, "An error occurred during execution.");
        }
    }
}