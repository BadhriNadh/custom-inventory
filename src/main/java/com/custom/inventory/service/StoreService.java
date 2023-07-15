package com.custom.inventory.service;

import com.custom.inventory.model.Store;
import com.custom.inventory.protocol.RequestStore;
import com.custom.inventory.protocol.Response;
import com.custom.inventory.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreService {

    final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Response findStore(RequestStore requestStore){
        Store store = storeRepository.findStore(requestStore.getName(), requestStore.getEmail());
        List<String> zoneNames = new java.util.ArrayList<>();

        if(store == null){
            return new Response(zoneNames, HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.name());
        }

        store.getZones().forEach(zone -> zoneNames.add(zone.getZoneName()));

        return new Response(zoneNames, HttpStatus.OK.value(), HttpStatus.OK.name());
    }

    public List<String> createStore(RequestStore requestStore){
        storeRepository.createStore(requestStore);
        return new java.util.ArrayList<>();
    }
}
