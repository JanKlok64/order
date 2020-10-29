package com.switchfully.jan.order.instances;

import java.util.UUID;

public class Item {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Item(String id, String name, String description, double price, int stock) {
        if (id == null)
            this.id = UUID.randomUUID().toString();
        else
            this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
