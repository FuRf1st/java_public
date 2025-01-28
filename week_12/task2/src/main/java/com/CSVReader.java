package com;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<HouseData> readData(String filePath) throws IOException {
        List<HouseData> data = new ArrayList<>();
        
        try (FileReader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(reader);
            for (CSVRecord record : records) {
                try {
                    String city = record.get("City");
                    int year = Integer.parseInt(record.get("Year"));
                    double price = Double.parseDouble(record.get("Price"));
                    data.add(new HouseData(city, year, price));
                } catch (Exception e) {
                    // Пропустить некорректные строки
                }
            }
        }
        return data;
    }
}

