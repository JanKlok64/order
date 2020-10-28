package com.switchfully.jan.order.controlers.dto;

public class AddItemDto {
    private String name;
    private String description;
    private double price;
    private int stock;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public AddItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public AddItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public AddItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public AddItemDto setStock(int stock) {
        this.stock = stock;
        return this;
    }
}
