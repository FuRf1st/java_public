package com.example;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DataProcessor {

    public Map<String, Map<Integer, Double>> calculateMaxPricesByCityAndYear(List<HousePriceRecord> records) {
        // Use a regular Map for the outer collection to avoid issues with ConcurrentMap
        return records.parallelStream()
                .collect(Collectors.groupingBy(
                        HousePriceRecord::getCity, // First group by city
                        Collectors.groupingBy(
                                HousePriceRecord::getYear, // Then group by year within each city
                                Collectors.collectingAndThen(
                                        Collectors.maxBy((r1, r2) -> Double.compare(r1.getPrice(), r2.getPrice())), // Get the max price
                                        opt -> opt.map(HousePriceRecord::getPrice).orElse(0.0) // Extract the price or use 0.0 if empty
                                )
                        )
                ));
    }
}
