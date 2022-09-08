package com.example.nhi.item_management.model;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
