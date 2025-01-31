package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HousePriceAnalyzer {
    public static Map<Integer, Map<String, Integer>> getYearlyMaxPrices(List<HousePriceRecord> records) {
        return records.stream()
                .collect(Collectors.groupingBy(
                        HousePriceRecord::getYear,
                        Collectors.toMap(
                                HousePriceRecord::getCity,
                                HousePriceRecord::getPrice,
                                Math::max // Берем максимальную цену
                        )
                ));
    }
}