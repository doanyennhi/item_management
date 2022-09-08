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

    @PostMapping("/")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        itemDao.addItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("/item{id}")
    public ResponseEntity<Item> getOneItem(@PathVariable String id) {
        try {
            Item item = itemDao.getOneItem(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/item/item")
    public Items getAllItems() {
        return itemDao.getItems();
    }

}
