package com.switchfully.jan.order.repositories;

import com.switchfully.jan.order.instances.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getId(),order);
    }

    public Collection<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

}
