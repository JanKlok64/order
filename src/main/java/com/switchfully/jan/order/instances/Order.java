package com.switchfully.jan.order.instances;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class Order {
    private String id;
    private LocalDate orderDate;
    private String customerId;
    private Collection<ItemGroup> itemGroups;

    public Order(LocalDate orderDate, String customerId, Collection<ItemGroup> itemGroups) {
        this.id = UUID.randomUUID().toString();
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.itemGroups = itemGroups;
    }

    public String getId() {
        return id;
    }

    public Collection<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
