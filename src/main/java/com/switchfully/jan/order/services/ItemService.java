package com.switchfully.jan.order.services;

import com.switchfully.jan.order.instances.Item;
import com.switchfully.jan.order.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item) {
        itemRepository.addItem(item);
    }

    public Collection<Item> getItems() {
        return itemRepository.getItems();
    }

    public Item getItemById(String id) {
        return itemRepository.getItemById(id);
    }

    public void updateItem(Item itemToUpdate) {
        itemRepository.addItem(itemToUpdate);
    }
}
