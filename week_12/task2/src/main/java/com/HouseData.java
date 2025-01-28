package com;

public class HouseData {

    private String city;
    private int year;
    private double price;

    public HouseData(String city, int year, double price) {
        this.city = city;
        this.year = year;
        this.price = price;
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