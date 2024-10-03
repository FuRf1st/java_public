package com;

public class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Успешно внесено: " + amount);
        } else {
            System.out.println("Ошибка! Неверно указана сумма депозита.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Успешно выведено: " + amount);
        } else if (amount > balance) {
            System.out.println("Ошибка! Недостаточно средств");
        } else {
            System.out.println("Ошибка! Неверно указана сумма снятия.");
        }
    }

    public double getBalance() { 
        return balance;
    }

    public String getAccountNumber() { 
        return accountNumber;
    }
}