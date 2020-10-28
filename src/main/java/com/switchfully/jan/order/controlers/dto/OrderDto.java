package com.switchfully.jan.order.controlers.dto;

import com.switchfully.jan.order.instances.ItemGroup;

import java.time.LocalDate;
import java.util.Collection;

public class OrderDto {
    private String id;
    private LocalDate orderDate;
    private String customerId;
    private Collection<ItemGroup> itemGroups;

    public String getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Collection<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public OrderDto setId(String id) {
        this.id = id;
        return this;
    }

    public OrderDto setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderDto setItemGroups(Collection<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }
}
