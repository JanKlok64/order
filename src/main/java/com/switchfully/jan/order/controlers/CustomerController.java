package com.switchfully.jan.order.controlers;

import com.switchfully.jan.order.controlers.dto.AddressDto;
import com.switchfully.jan.order.controlers.dto.CustomerDto;
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
    public void addCustomer(@RequestBody CustomerDto addCustomerDto, AddressDto addAddressDto) {
        Address address = new Address(addAddressDto.getStreet(), addAddressDto.getHouseNumber(), addAddressDto.getPostalCode(), addAddressDto.getCityName());
        Customer customer = new Customer(null,addCustomerDto.getFirstName(), addCustomerDto.getLastName(), addCustomerDto.getEmail(), address, addCustomerDto.getPhoneNumber());
        customerService.addCustomer(customer);
        myLogger.info("Customer created");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<CustomerDto> getAllCustomers(@RequestParam String adminId) {
        if (adminId == null || adminId.isBlank() || !adminIsMatched(adminId)) {
            throw new NotAuthorizedException("Invalid adminId provided");
        }
        myLogger.info("List of customers delivered");
        return customerService.getAllCustomers().stream()
                .map(customer -> new CustomerDto()
                        .setUuid(customer.getId())
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

    @GetMapping(path = "/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomer(@PathVariable String itemId, @RequestParam String adminId) {
        myLogger.info("Reading customer");
        if (adminId == null || adminId.isBlank() || !adminIsMatched(adminId)) {
            throw new NotAuthorizedException("Invalid adminId provided");
        }
        myLogger.info("Customer read by id");
        Customer customer = customerService.getCustomer(itemId);
        return new CustomerDto()
                .setUuid(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setEmail(customer.getEmail())
                .setAddress(new Address(customer.getAddress().getStreet(),
                        customer.getAddress().getHouseNumber(),
                        customer.getAddress().getPostalCode(),
                        customer.getAddress().getCityName()))
                .setPhoneNumber(customer.getPhoneNumber());
    }

    public boolean adminIsMatched(String adminId) {
        for (Admin admin:adminService.getAdmins()) {
            if (admin.getId().equals(adminId))
                return true;
        }
        return false;
    }
}
