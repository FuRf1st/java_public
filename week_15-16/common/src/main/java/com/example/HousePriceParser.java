package com.example;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HousePriceParser {
    public static List<HousePriceRecord> parseLines(List<String> lines) {
        return lines.stream()
                .map(HousePriceParser::parseLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static HousePriceRecord parseLine(String line) {
        try {
            String[] fields = line.split("\",\""); // Разделяем по запятой и кавычкам
            if (fields.length < 4) {
                throw new IllegalArgumentException("Invalid CSV line: " + line);
            }
            int price = Integer.parseInt(fields[1].replaceAll("\\D", ""));
            String date = fields[2].replace("\"", "");
            String city = fields[fields.length - 3].replace("\"", "");
            if (date.length() < 4) {
                throw new IllegalArgumentException("Invalid date format: " + date);
            }
            int year = Integer.parseInt(date.substring(0, 4));
            return new HousePriceRecord(year, city, price);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}