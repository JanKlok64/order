package com.switchfully.jan.order.services;

import com.switchfully.jan.order.exceptions.OrderCreationFailedException;
import com.switchfully.jan.order.instances.Customer;
import com.switchfully.jan.order.instances.Item;
import com.switchfully.jan.order.instances.ItemGroup;
import com.switchfully.jan.order.instances.Order;
import com.switchfully.jan.order.repositories.CustomerRepository;
import com.switchfully.jan.order.repositories.ItemRepository;
import com.switchfully.jan.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    public void addOrder(Order order) {
        // check if customer exists
        Customer customer = customerRepository.getCustomer(order.getCustomerId());
        if (customer == null) throw new OrderCreationFailedException("Customer " + order.getCustomerId() + " not found in repository");

        // set itemgroup amount to amount * item price
        for (ItemGroup itemGroup: order.getItemGroups()) {
            Item item = itemRepository.getItemById(itemGroup.getItemId());
            if (item == null) throw new OrderCreationFailedException("Item " + itemGroup.getItemId() + " not found in repository");
            double itemPrice = item.getPrice();
            double groupAmount = itemGroup.getAmount();
            itemGroup.setAmount(groupAmount * itemPrice);
        }

        // add the order
        orderRepository.addOrder(order);
    }

    public Collection<Order> getOrders() {
        return orderRepository.getOrders();
    }

}
