package com.switchfully.jan.order.instances;

import com.switchfully.jan.order.repositories.ItemRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void givenEmptyItemRepository_whenItemIsAdded_ItemRepositoryIsSize1() {
        //given
        int expectedItemRepositorySize = 1;
        ItemRepository itemRepository = new ItemRepository();
        //when
        itemRepository.addItem(new Item("item","item description",24.99,10));
        //then
        assertEquals(expectedItemRepositorySize,itemRepository.getItems().size());
    }
}