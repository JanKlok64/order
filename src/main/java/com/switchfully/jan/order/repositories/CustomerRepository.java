package com.switchfully.jan.order.repositories;

import com.switchfully.jan.order.instances.Address;
import com.switchfully.jan.order.instances.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {
    private final Map<String, Customer> customers = new HashMap<>();

    public CustomerRepository() {
        Address address1 = new Address("Oudebaan", "191", "3000", "Leuven");
        Customer customer1 = new Customer("Jan", "Klok", "jan@klok.com", address1, "0484246262");
        customers.put(customer1.getUuid(), customer1);
        Address address2 = new Address("Oudebaan", "191", "3000", "Leuven");
        Customer customer2 = new Customer("Lieve", "Klok", "jan@klok.com", address2, "0484246262");
        customers.put(customer2.getUuid(), customer2);
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getUuid(), customer);
    }

    public Collection<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomer(String id) {
        for (Customer customer: customers.values()) {
            if (customer.getUuid().equals(id))
                return customer;
        }
        return null;
    }
}
