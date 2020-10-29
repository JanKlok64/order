package com.switchfully.jan.order.instances;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private String id;
    private String itemId;
    private double amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemId, int amount, LocalDate shippingDate) {
        this.id = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
