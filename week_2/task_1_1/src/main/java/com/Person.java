package com;

public class Person {
        // Атрибуты класса
        private String name;
        private String birth_date;
        private String city;
    
        // Конструктор по умолчанию
        public Person() {
            this.name = "Неизвестно";
            this.birth_date = "Неизвестно";
            this.city = "Неизвестно";
        }
    
        // Конструктор с параметрами
        public Person(String name, String birth_date, String city) {
            this.name = name;
            this.birth_date = birth_date;
            this.city = city;
        }
    
        // Геттеры
        public String getName() {
            return name;
        }
    
        public String getbirth_date() {
            return birth_date;
        }
    
        public String getCity() {
            return city;
        }
    
        // Сеттеры
        public void setName(String name) {
            this.name = name;
        }
    
        public void setbirth_date(String birth_date) {
            this.birth_date = birth_date;
        }
    
        public void setCity(String city) {
            this.city = city;
        }
    
        // Вывод информации
        public void displayInfo() {
            System.out.println("Имя: " + name);
            System.out.println("Дата рождения: " + birth_date);
            System.out.println("Город рождения: " + city);
        }
}
