package com.switchfully.jan.order.controlers;

import com.switchfully.jan.order.controlers.dto.ItemDto;
import com.switchfully.jan.order.controlers.dto.OrderDto;
import com.switchfully.jan.order.exceptions.NotAuthorizedException;
import com.switchfully.jan.order.instances.Item;
import com.switchfully.jan.order.instances.Order;
import com.switchfully.jan.order.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final Logger myLogger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody OrderDto addOrderDto) {
        Order order = new Order(addOrderDto.getId(), addOrderDto.getOrderDate(), addOrderDto.getCustomerId(), addOrderDto.getItemGroups());
        orderService.addOrder(order);
        myLogger.info("Order created");
    }


}
