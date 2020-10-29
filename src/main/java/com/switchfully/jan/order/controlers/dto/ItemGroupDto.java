package com.switchfully.jan.order.controlers.dto;

import java.time.LocalDate;

public class ItemGroupDto {
    private String id;
    private String itemId;
    private double amount;
    private LocalDate shippingDate;

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public ItemGroupDto setId(String id) {
        this.id = id;
        return this;
    }

    public ItemGroupDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDto setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public ItemGroupDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
