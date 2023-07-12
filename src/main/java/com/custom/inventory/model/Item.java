package com.custom.inventory.model;


public class Item {
    private String itemName;
    private Integer count;

    public Item(String itemName, Integer count) {
        this.itemName = itemName;
        this.count = count;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
