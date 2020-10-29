package com.switchfully.jan.order.controlers.dto;

public class ItemDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public String getId() {
        return id;
    }

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

    public ItemDto setId(String id) {
        this.id = id;
        return this;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemDto setStock(int stock) {
        this.stock = stock;
        return this;
    }
}
