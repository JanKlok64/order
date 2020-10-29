package com.switchfully.jan.order.controlers;

import com.switchfully.jan.order.controlers.dto.AdminDto;
import com.switchfully.jan.order.controlers.dto.ItemDto;
import com.switchfully.jan.order.exceptions.NotAuthorizedException;
import com.switchfully.jan.order.instances.Address;
import com.switchfully.jan.order.instances.Admin;
import com.switchfully.jan.order.instances.Item;
import com.switchfully.jan.order.services.AdminService;
import com.switchfully.jan.order.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final Logger myLogger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final AdminService adminService;

    @Autowired
    public ItemController(ItemService itemService, AdminService adminService) {
        this.itemService = itemService;
        this.adminService = adminService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody ItemDto addItemDto, @RequestParam (required = false) String adminId) {
        if (adminId == null || adminId.isBlank() || !adminIsMatched(adminId)) {
            throw new NotAuthorizedException("Invalid adminId provided");
        }
        Item item = new Item(addItemDto.getName(), addItemDto.getDescription(), addItemDto.getPrice(), addItemDto.getStock());
        itemService.addItem(item);
        myLogger.info("Item created");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<ItemDto> getItems() {
        myLogger.info("List of items delivered");
        return itemService.getItems().stream()
                .map(item -> new ItemDto()
                        .setId(item.getId())
                        .setName(item.getName())
                        .setDescription(item.getDescription())
                        .setPrice(item.getPrice())
                        .setStock(item.getStock()))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@PathVariable String id, @RequestBody ItemDto itemDto, @RequestParam String adminId) {
        Item itemToUpdate = itemService.getItemById(id);
        itemToUpdate.setName(itemDto.getName());
        itemToUpdate.setDescription(itemDto.getDescription());
        itemToUpdate.setPrice(itemDto.getPrice());
        itemToUpdate.setStock(itemDto.getStock());
        itemService.updateItem(itemToUpdate);
        myLogger.info("Item with id " + id + " updated.");
    }

    public boolean adminIsMatched(String adminId) {
        for (Admin admin:adminService.getAdmins()) {
            if (admin.getId().equals(adminId))
                return true;
        }
        return false;
    }

}
