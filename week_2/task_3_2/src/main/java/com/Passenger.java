package com;

class Passenger {
    private String name; // Имя пассажира

    // Конструктор класса Passenger
    public Passenger(String name) {
        this.name = name;
    }

    // Геттер для имени пассажира
    public String getName() {
        return name;
    }

    // Метод для получения информации о пассажире
    public String getPassengerInfo() {
        return "Пассажир: " + name;
    }
}