package com;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class ShannonEntropyCalculator implements Runnable {
    private final String filePath;

    public ShannonEntropyCalculator(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            Map<Byte, Long> frequencyMap = new HashMap<>();
            long totalBytes = 0;
            byte[] buffer = new byte[1024 * 1024]; // Читаем файл частями по 1 MB

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                totalBytes += bytesRead;
                for (int i = 0; i < bytesRead; i++) {
                    byte b = buffer[i];
                    frequencyMap.put(b, frequencyMap.getOrDefault(b, 0L) + 1);
                }
            }

            // Вычисляем энтропию
            double entropy = 0.0;
            for (long count : frequencyMap.values()) {
                double probability = (double) count / totalBytes;
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }

            System.out.println("Энтропия Шеннона: " + entropy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
