package com;

public class Main{
public static void main(String[] args) {
    // Создаем объект автора
    Author author = new Author("Генри Киссинджер", 1923);

    // Создаем объект книги с автором
    Book book = new Book("Мировой порядок", author);

    // Вывод информации о книге и авторе
    System.out.println(book.getBookInfo());
    }
}