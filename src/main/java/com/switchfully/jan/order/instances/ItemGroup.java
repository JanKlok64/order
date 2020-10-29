package com.switchfully.jan.order.instances;

import java.time.LocalDate;

public class ItemGroup {
    private String itemId;
    private int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemId, int amount, LocalDate shippingDate) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public int getAmount() {
        return amount;
    }
}
