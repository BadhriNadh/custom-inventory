package com.custom.inventory.service;

import com.custom.inventory.model.Item;
import com.custom.inventory.model.Store;
import com.custom.inventory.protocol.RequestStore;
import com.custom.inventory.protocol.Response;
import com.custom.inventory.repository.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StoreService {

    final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Response findStore(RequestStore requestStore){
        Store store = storeRepository.findStore(requestStore.getName(), requestStore.getEmail());
        ArrayList<Object> zoneNames = new ArrayList<>();

        if(store == null){
            return new Response(zoneNames, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
        }

        store.getZones().forEach(zone -> zoneNames.add(zone.getZoneName()));
        List<Item> items = store.getZones().stream()
                .flatMap(zone -> zone.getItems().stream()
                        .map(item -> new Item(zone.getZoneName(), item.getItemName(), item.getCount())))
                .toList();

        HashMap<String, ArrayList<Object>> result = new HashMap<String, ArrayList<Object>>();
        result.put("zones", zoneNames);
        result.put("items", new ArrayList<>(items));

        return new Response(result, HttpStatus.OK.value(), HttpStatus.OK.name());
    }

    public Response createStore(RequestStore requestStore){
        Store store = storeRepository.findStore(requestStore.getName(), requestStore.getEmail());
        ArrayList<String> zoneNames = new ArrayList<>();

        if(store == null){
            storeRepository.createStore(requestStore);
            return new Response(zoneNames, HttpStatus.CREATED.value(), HttpStatus.CREATED.name());
        }

        return new Response(zoneNames, HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name());
    }
}
