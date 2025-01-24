package com;

public interface Stack<T> {
    void push(T element); // Добавить элемент в стек
    T pop(); // Извлечь верхний элемент
    T peek(); // Посмотреть верхний элемент
    boolean isEmpty(); // Проверить, пуст ли стек
    int size(); // Получить размер стека
}