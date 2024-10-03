package com;

public class Book {
    private String title;      // Название книги
    private Author author;     // Объект класса Author

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    // Геттер и Сеттер для названия книги
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Геттер и Сеттер для автора книги
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public String getBookInfo() {
        return "Книга: " + title + "\n" + author.getAuthorInfo();
    }
}
