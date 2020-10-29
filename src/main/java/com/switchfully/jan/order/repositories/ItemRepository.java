package com.switchfully.jan.order.repositories;

import com.switchfully.jan.order.instances.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {
    private final Map<String, Item> items = new HashMap<>();

    public ItemRepository() {
        addItem(new Item("1","Shoes","Blue suede shoes",79.99,10));
        addItem(new Item("2","Shirts","Wet t-shirts",19.99,20));
    }

    public void addItem(Item item) {
        items.put(item.getId(), item);
    }

    public Collection<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    public Item getItemById(String itemId) {
        for (Item item: items.values()) {
            if (item.getId().equals(itemId))
                return item;
        }
        return null;
    }
}
