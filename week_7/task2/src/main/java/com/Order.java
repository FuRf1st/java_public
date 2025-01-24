package com;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private int id;
    private LocalDate orderDate;    // Уже есть
    private LocalDate deliveryDate; // Добавляем это поле
    private List<Product> products;

    // Геттеры и сеттеры для deliveryDate
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    // Остальные геттеры/сеттеры (id, orderDate, products)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

