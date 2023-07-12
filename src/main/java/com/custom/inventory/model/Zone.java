package com.custom.inventory.model;

import java.util.List;

public class Zone {
    private String zoneName;
    private List<Item> items;

    public Zone(String zoneName, List<Item> items) {
        this.zoneName = zoneName;
        this.items = items;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
