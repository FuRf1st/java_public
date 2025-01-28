package com.example;

import org.apache.commons.csv.CSVRecord;

public class HousePriceRecord {
    private final String city;
    private final int year;
    private final double price;

    public HousePriceRecord(CSVRecord record) {
        this.city = record.get(10); // Город (Southend-on-Sea, Chelmsford и т.д.)
        this.year = Integer.parseInt(record.get(2).split("-")[0]); // Год из даты
        this.price = Double.parseDouble(record.get(1).replace("'", "")); // Цена
    }

    public String getCity() {
        return city;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}