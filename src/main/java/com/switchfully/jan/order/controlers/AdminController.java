package com.switchfully.jan.order.controlers;

import com.switchfully.jan.order.controlers.dto.AdminDto;
import com.switchfully.jan.order.instances.Address;
import com.switchfully.jan.order.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/admins")

public class AdminController {
    private final Logger myLogger = LoggerFactory.getLogger(CustomerController.class);
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<AdminDto> getAdmins() {
        myLogger.info("List of admins delivered");
        return adminService.getAdmins().stream()
                .map(admin -> new AdminDto()
                        .setUuid(admin.getId())
                        .setFirstName(admin.getFirstName())
                        .setLastName(admin.getLastName())
                        .setEmail(admin.getEmail())
                        .setAddress(new Address(admin.getAddress().getStreet(),
                                admin.getAddress().getHouseNumber(),
                                admin.getAddress().getPostalCode(),
                                admin.getAddress().getCityName()))
                        .setPhoneNumber(admin.getPhoneNumber()))
                .collect(Collectors.toList());
    }


}
