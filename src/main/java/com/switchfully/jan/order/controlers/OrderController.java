package com.switchfully.jan.order.controlers;

import com.switchfully.jan.order.controlers.dto.ItemDto;
import com.switchfully.jan.order.controlers.dto.ItemGroupDto;
import com.switchfully.jan.order.controlers.dto.OrderDto;
import com.switchfully.jan.order.exceptions.NotAuthorizedException;
import com.switchfully.jan.order.instances.Item;
import com.switchfully.jan.order.instances.Order;
import com.switchfully.jan.order.services.ItemService;
import com.switchfully.jan.order.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final Logger myLogger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private final ItemService itemService;

    @Autowired
    public OrderController(OrderService orderService, ItemService itemService) {
        this.orderService = orderService;
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody OrderDto addOrderDto) {
        Order order = new Order(addOrderDto.getOrderDate(), addOrderDto.getCustomerId(), addOrderDto.getItemGroups());
        orderService.addOrder(order);
        myLogger.info("Order created");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<OrderDto> getOrders() {
        myLogger.info("List of orders delivered");
        return orderService.getOrders().stream()
                .map(order -> new OrderDto()
                        .setOrderDate(order.getOrderDate())
                        .setCustomerId(order.getCustomerId())
                        .setItemGroups(null))
                .collect(Collectors.toList());
    }



}
