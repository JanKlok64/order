package com.switchfully.jan.order.instances;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void givenOneItem_whenOrderIsCreatedWithItemForCustomer_thenOrderWithItemIsThere() {
        //given
        Item item = new Item("Shoes","Blue suede shoes",79.99,5);
        String itemId = item.getId();
        Collection<ItemGroup> itemGroups = new ArrayList<>();
        ItemGroup itemGroup = new ItemGroup(item.getId(),1, LocalDate.of(2020,10,29));
        itemGroups.add(itemGroup);
        //when
        Address address = new Address("Oudebaan","191","3000","Leuven");
        Customer customer = new Customer("Jan","Klok","jan@klok.be",address,"0484246262");
        Order order = new Order(LocalDate.of(2020,10,28),customer.getId(),itemGroups);
        //then
        assertEquals("Blue suede shoes",item.getDescription());
        assertEquals(1,itemGroup.getAmount());
        assertEquals("Oudebaan",customer.getAddress().getStreet());
        assertNotEquals(null,order);
        assertEquals(1,order.getItemGroups().size());
        assertTrue(itemGroups.contains(itemGroup));
    }
}