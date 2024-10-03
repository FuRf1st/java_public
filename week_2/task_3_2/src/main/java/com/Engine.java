package com;

class Engine {
    private int power; // Мощность двигателя

    public Engine(int power) {
        this.power = power;
    }

    // Геттер для мощности двигателя
    public int getPower() {
        return power;
    }

    public String getEngineInfo() {
        return "Мощность двигателя: " + power + "ЛС";
    }
}