package com;

class Car {
    private String model;      // Модель автомобиля
    private Engine engine;      // Объект двигателя автомобиля
    private Passenger passenger1; // Первый пассажир
    private Passenger passenger2; // Второй пассажир

    // Конструктор для создания нового объекта автомобиля
    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.passenger1 = null;
        this.passenger2 = null;
    }

    // Метод для добавления пассажира в автомобиль
    public void addPassenger(Passenger passenger) {
        if (passenger1 == null) {
            passenger1 = passenger;
            System.out.println(passenger.getName() + " добавлен, как Пассажир №1.");
        } else if (passenger2 == null) {
            passenger2 = passenger;
            System.out.println(passenger.getName() + " добавлен, как Пассажир №2.");
        } else {
            System.out.println("Машина полная. " + passenger.getName() + " не может войти.");
        }
    }

    // Метод для удаления пассажира из автомобиля
    public void removePassenger(Passenger passenger) {
        if (passenger1 != null && passenger1.getName().equals(passenger.getName())) {
            System.out.println(passenger.getName() + " удалён, как Пассажир №1.");
            passenger1 = null;
        } else if (passenger2 != null && passenger2.getName().equals(passenger.getName())) {
            System.out.println(passenger.getName() + " удалён, как Пассажир №2.");
            passenger2 = null;
        } else {
            System.out.println(passenger.getName() + " не в машине.");
        }
    }

    // Метод для отображения информации об автомобиле и его пассажирах
    public void displayInfo() {
        System.out.println("Модель машины: " + model);
        System.out.println(engine.getEngineInfo());
        
        if (passenger1 != null) {
            System.out.println(passenger1.getPassengerInfo());
        } else {
            System.out.println("Пассажир №1: Нет");
        }
        
        if (passenger2 != null) {
            System.out.println(passenger2.getPassengerInfo());
        } else {
            System.out.println("Пассажир №2: Нет");
        }
    }
}