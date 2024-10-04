package com;

public class Main{
public static void main(String[] args) {
    // Создаем объект автора, в котором ошибка в дате рождения и фамилии автора
    Author author = new Author("Генри Киссенджер", 1922);

    // Создаем объект книги с автором
    Book book = new Book("Мировой порядок", author);

    // Вывод информации о книге и авторе
    System.out.println(book.getBookInfo());

    System.out.println("\nИсправленные данные об авторе книги:\n");
    
    // Изменяем информацию об авторе на верную
    author.setName("Генри Киссинджер");
    author.setBirthYear(1923);

    // Вывод исправленной информации о книге и авторе
    System.out.println(book.getBookInfo());
    }
}