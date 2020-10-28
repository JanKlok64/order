package com.switchfully.jan.order.repositories;

import com.switchfully.jan.order.instances.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getId(),order);
    }
}
