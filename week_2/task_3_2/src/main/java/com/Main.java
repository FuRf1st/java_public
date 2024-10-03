package com;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(145);

        Car car = new Car("Toyota Supra MkII 'L-Type'", engine);

        Passenger passenger1 = new Passenger("Артём");
        Passenger passenger2 = new Passenger("Роман");
        Passenger passenger3 = new Passenger("Алексей");
        
        // 1-ая проверка информации об авто
        car.displayInfo();

        // Добавили пассажиров
        car.addPassenger(passenger1);
        car.addPassenger(passenger2);
        car.addPassenger(passenger3);
        
        // 2-ая проверка информации об авто
        car.displayInfo();

        // Убираем 1-го пассажира
        car.removePassenger(passenger2);

        // 3-я проверка информации об авто
        car.displayInfo();

    }
}