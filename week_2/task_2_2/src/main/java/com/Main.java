package com;

public class Main {
    public static void main(String[] args) {
        // Пример использования
        BankAccount account = new BankAccount("123456789", 2195.23);

        // Операции со счётом
        System.out.println("Баланс: " + account.getBalance());

        account.deposit(1200.0);
        System.out.println("Баланс после внесения: " + account.getBalance());

        account.withdraw(1500.0);
        System.out.println("Баланс после снятия: " + account.getBalance());

        account.withdraw(4000.0); // Попытка снять больше, чем доступно
    }
}
