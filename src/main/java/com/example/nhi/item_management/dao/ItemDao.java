package com.example.nhi.item_management.dao;

import com.example.nhi.item_management.exception.ItemNotFoundException;
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

    public Item getOneItem(String id) throws ItemNotFoundException {
        for (Item currentItem: items.getItemList()) {
            if (currentItem.getId().equals(id)) {
                return currentItem;
            }
        }
        throw new ItemNotFoundException();
    }

    public void addItem(Item item) {
        items.getItemList().add(item);
    }

    public void updateItem(Item item) throws ItemNotFoundException {
       for (Item currentItem: items.getItemList()) {
           if (item.getId().equals(currentItem.getId())) {
               items.getItemList().remove(currentItem);
               items.getItemList().add(item);
               return;
           }
       }
        throw new ItemNotFoundException();
    }

    public void deleteItem(Item item) throws ItemNotFoundException {
        for (Item currentItem: items.getItemList()) {
            if (item.getId().equals(currentItem.getId())) {
                items.getItemList().remove(currentItem);
                return;
            }
        }
        throw new ItemNotFoundException();
    }
}
