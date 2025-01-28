package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class DataLoader {

    public List<HousePriceRecord> loadData(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            return csvParser.stream()
                    .parallel()
                    .map(HousePriceRecord::new)
                    .collect(Collectors.toList());
        }
    }
}
