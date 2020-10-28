package com.switchfully.jan.order.controlers;

import com.switchfully.jan.order.controlers.dto.AddAddressDto;
import com.switchfully.jan.order.controlers.dto.AddCustomerDto;
import com.switchfully.jan.order.exceptions.NotAuthorizedException;
import com.switchfully.jan.order.instances.Address;
import com.switchfully.jan.order.instances.Admin;
import com.switchfully.jan.order.instances.Customer;
import com.switchfully.jan.order.services.AdminService;
import com.switchfully.jan.order.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final Logger myLogger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final AdminService adminService;

    @Autowired
    public CustomerController(CustomerService customerService, AdminService adminService) {
        this.customerService = customerService;
        this.adminService = adminService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody AddCustomerDto addCustomerDto, AddAddressDto addAddressDto) {
        Address address = new Address(addAddressDto.getStreet(), addAddressDto.getHouseNumber(), addAddressDto.getPostalCode(), addAddressDto.getCityName());
        Customer customer = new Customer(addCustomerDto.getFirstName(), addCustomerDto.getLastName(), addCustomerDto.getEmail(), address, addCustomerDto.getPhoneNumber());
        customerService.addCustomer(customer);
        myLogger.info("Customer created");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<AddCustomerDto> getCustomers(@RequestParam (required = false) String adminId) {
        if (adminId == null || adminId.isBlank() || !adminIsMatched(adminId)) {
            throw new NotAuthorizedException("Invalid adminId provided");
        }
        myLogger.info("List of customers delivered");
        return customerService.getCustomers().stream()
                .map(customer -> new AddCustomerDto()
                        .setUuid(customer.getUuid())
                        .setFirstName(customer.getFirstName())
                        .setLastName(customer.getLastName())
                        .setEmail(customer.getEmail())
                        .setAddress(new Address(customer.getAddress().getStreet(),
                                customer.getAddress().getHouseNumber(),
                                customer.getAddress().getPostalCode(),
                                customer.getAddress().getCityName()))
                        .setPhoneNumber(customer.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    public boolean adminIsMatched(String adminId) {
        for (Admin admin:adminService.getAdmins()) {
            if (admin.getUuid().equals(adminId))
                return true;
        }
        return false;
    }

}
