package com.switchfully.jan.order.controlers;

import com.switchfully.jan.order.controlers.dto.AddAddressDto;
import com.switchfully.jan.order.controlers.dto.AddCustomerDto;
import com.switchfully.jan.order.controlers.dto.AddItemDto;
import com.switchfully.jan.order.exceptions.NotAuthorizedException;
import com.switchfully.jan.order.instances.Address;
import com.switchfully.jan.order.instances.Admin;
import com.switchfully.jan.order.instances.Customer;
import com.switchfully.jan.order.instances.Item;
import com.switchfully.jan.order.services.AdminService;
import com.switchfully.jan.order.services.CustomerService;
import com.switchfully.jan.order.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public void addCustomer(@RequestBody AddItemDto addItemDto, @RequestParam (required = false) String adminId) {
        if (adminId == null || adminId.isBlank() || !adminIsMatched(adminId)) {
            throw new NotAuthorizedException("Invalid adminId provided");
        }
        Item item = new Item(addItemDto.getName(), addItemDto.getDescription(), addItemDto.getPrice(), addItemDto.getStock());
        itemService.addItem(item);
        myLogger.info("Item created");
    }

    public boolean adminIsMatched(String adminId) {
        for (Admin admin:adminService.getAdmins()) {
            if (admin.getUuid().equals(adminId))
                return true;
        }
        return false;
    }

}
