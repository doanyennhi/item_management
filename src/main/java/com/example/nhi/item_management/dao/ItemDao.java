package com.example.nhi.item_management.dao;

import com.example.nhi.item_management.model.Item;
import com.example.nhi.item_management.model.Items;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

    private static final Items items = new Items();

    static {
        items.getItemList().add(new Item("1", "yeonjun", "lonely boy", 13.90));
        items.getItemList().add(new Item("2", "beomgyu", "run away", 13.30));
        items.getItemList().add(new Item("3", "junho", "chasing tails", 30.12));
    }

    public Items getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.getItemList().add(item);
    }

    public void updateItem(Item item) throws Exception {
       for (Item currentItem: items.getItemList()) {
           if (item.getId().equals(currentItem.getId())) {
               items.getItemList().remove(currentItem);
               items.getItemList().add(item);
           }
           else {
               throw new Exception("Item does not exist.");
           }
       }
    }

    public void deleteItem(Item item) {
        items.getItemList().remove(item);
    }
}
