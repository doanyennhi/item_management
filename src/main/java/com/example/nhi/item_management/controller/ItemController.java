package com.example.nhi.item_management.controller;

import com.example.nhi.item_management.dao.ItemDao;
import com.example.nhi.item_management.model.Item;
import com.example.nhi.item_management.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @PostMapping("")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        itemDao.addItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("/item{id}")
    public Item getOneItem(@PathVariable String id) {
        try {
            return itemDao.getOneItem(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/item")
    public Items getAllItems() {
        return itemDao.getItems();
    }

    @PutMapping("/item")
    public String updateItem(@RequestBody Item item) {
        try {
            itemDao.updateItem(item);
            return "Update successfully";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/item")
    public String deleteItem(@RequestBody Item item) {
        try {
            itemDao.deleteItem(item);
            return "Delete successfully";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
