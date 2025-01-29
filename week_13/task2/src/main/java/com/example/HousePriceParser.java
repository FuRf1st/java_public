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
            String[] fields = line.split(",");
            int price = Integer.parseInt(fields[1].replaceAll("\\D", ""));
            String date = fields[2].replace("\"", "");
            String city = fields[fields.length - 3].replace("\"", "");
            int year = Integer.parseInt(date.substring(0, 4));
            return new HousePriceRecord(year, city, price);
        } catch (Exception e) {
            return null;
        }
    }
}
