package com.switchfully.jan.order.instances;

import com.switchfully.jan.order.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void givenCustomerWithAddress_whenCustomerIsAdded_thenCustomerIsCreatedWithAddress() {
        //given
        String customerLastName = "Patat";
        String customerStreet = "Nieuwstraat";
        //when
        Address address = new Address(customerStreet,"1A","1000","Brussel");
        Customer customer = new Customer("Jef",customerLastName,"jef@patat.be", address, "027778899");
        //then
        assertEquals(customerLastName,customer.getLastName());
        assertEquals(customerStreet,customer.getAddress().getStreet());
    }

    @Test
    void givenCustomerRepositoryWith2Customers_whenCustomerIsAdded_thenCustomerRepositorySizeIs3() {
        //given
        CustomerRepository customerRepository = new CustomerRepository();
        int expectedRepositorySize = 3;
        //when
        Address address = new Address("Nieuwstraat","1A","1000","Brussel");
        Customer customer = new Customer("Jef","Patat","jef@patat.be", address, "027778899");
        customerRepository.addCustomer(customer);
        //then
        assertEquals(expectedRepositorySize,customerRepository.getAllCustomers().size());
    }

    @Test
    void givenFirstCustomerInRepository_whenGetCustomerDetail_thenCustomerLastNameIsCorrect() {
        //given
        CustomerRepository customerRepository = new CustomerRepository();
        Customer firstCustomer = null;
        for (Customer customer: customerRepository.getAllCustomers()) {
            firstCustomer = customer;
            break;
        }
        String customerLastName = firstCustomer.getLastName();
        //when
        Customer wantedCustomer = customerRepository.getCustomer(firstCustomer.getUuid());
        //then
        assertEquals(firstCustomer.getLastName(),wantedCustomer.getLastName());
    }
}