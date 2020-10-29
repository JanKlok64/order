package com.switchfully.jan.order.instances;

import com.switchfully.jan.order.repositories.ItemRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void givenItemRepositoryWithTwoItems_whenItemIsAdded_ItemRepositoryIsSize3() {
        //given
        int expectedItemRepositorySize = 3;
        ItemRepository itemRepository = new ItemRepository();
        //when
        itemRepository.addItem(new Item("3","item","item description",24.99,10));
        //then
        assertEquals(expectedItemRepositorySize,itemRepository.getItems().size());
    }

    @Test
    void givenItem_whenItemNameIsUpdatedtoFOO_thenItemNameIsFOO() {
        //given
        ItemRepository itemRepository = new ItemRepository();
        Item itemToUpdate = itemRepository.getItemById("1");
        String oldName = itemToUpdate.getName();
        itemToUpdate.setName("FOO");
        //when
        itemRepository.updateItem(itemToUpdate);
        Item updatedItem = itemRepository.getItemById("1");
        String newName = updatedItem.getName();
        //then
        assertNotEquals(oldName,newName);
    }
}