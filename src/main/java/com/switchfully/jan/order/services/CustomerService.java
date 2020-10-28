package com.switchfully.jan.order.services;

import com.switchfully.jan.order.instances.Customer;
import com.switchfully.jan.order.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public Collection<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }
}
