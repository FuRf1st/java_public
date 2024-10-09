package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите день недели (1-Понедельник, ..., 7-Воскресенье): ");
        int dayofweek = scanner.nextInt();

        System.out.print("Введите температуру (жарко, тепло, холодно): ");
        String temperature = scanner.next();

        System.out.print("Введите осадки (ясно, облачно, дождь, снег, град): ");
        String precipitation = scanner.next();

        System.out.print("Есть ли ветер? (есть/нет): ");
        String wind = scanner.next();

        System.out.print("Влажность (высокая/низкая): ");
        String humidity = scanner.next();

        boolean decision = WeatherComputer.canPlayBadminton(dayofweek, temperature, precipitation, wind, humidity);

        if (decision) {
            System.out.println("Да, вы хотите играть в бадминтон.");
        } else {
            System.out.println("Нет, вы не хотите играть в бадминтон.");
        }
    }
}
