package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShannonFromFile {

    public double calculateEntropy(String filePath) throws IOException {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    int totalCharacters = 0;

    // Чтение файла и подсчёт частот символов
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        int c;
        while ((c = reader.read()) != -1) {
            char character = (char) c;
            // Увеличиваем счётчик для каждого символа
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
            totalCharacters++;
        }
    }

    if (totalCharacters == 0) {
        return 0.0;
    }

    // Вычисляем энтропию по Шеннону
    double entropy = 0.0;
    for (int frequency : frequencyMap.values()) {
        double probability = (double) frequency / totalCharacters;
        entropy -= probability * (Math.log(probability) / Math.log(2));
    }

    return entropy;
    }
}