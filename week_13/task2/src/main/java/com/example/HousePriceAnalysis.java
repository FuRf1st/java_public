package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class HousePriceAnalysis {

    public static void main(String[] args) throws IOException {
        String filePath = "/app/pp-2018.csv";

        // Чтение строк из файла
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Парсинг данных
        List<HousePriceRecord> records = HousePriceParser.parseLines(lines);

        // Анализ данных: вычисляем максимальные цены по годам и городам
        Map<Integer, Map<String, Integer>> yearlyMaxPrices = HousePriceAnalyzer.getYearlyMaxPrices(records);

        // Построение гистограммы
        HousePriceChart.createHistogram(yearlyMaxPrices);
    }
}
