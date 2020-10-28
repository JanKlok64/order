package com.switchfully.jan.order.repositories;

import com.switchfully.jan.order.instances.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {
    private final Map<String, Item> items = new HashMap<>();

    public void addItem(Item item) {
        items.put(item.getId(), item);
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
