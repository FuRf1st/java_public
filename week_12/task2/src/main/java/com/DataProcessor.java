package com;

import java.util.*;
import java.util.stream.Collectors;

public class DataProcessor {

    public static Map<Integer, Map<String, Double>> processDataParallel(List<HouseData> data) {
        return data.parallelStream()
                .collect(Collectors.groupingBy(HouseData::getYear,
                        Collectors.groupingBy(HouseData::getCity,
                                Collectors.maxBy(Comparator.comparingDouble(HouseData::getPrice))))
                )
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        e -> e.getValue().get().getPrice()
                                ))
                ));
    }
}
