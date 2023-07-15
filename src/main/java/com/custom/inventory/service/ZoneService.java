package com.custom.inventory.service;

import com.custom.inventory.model.Store;
import com.custom.inventory.model.Zone;
import com.custom.inventory.protocol.RequestZone;
import com.custom.inventory.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ZoneService {

    final StoreRepository storeRepository;

    public ZoneService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<String> createZone(RequestZone requestZone){
        Store store = storeRepository.findStore(requestZone.getName(), requestZone.getEmail());

        List<Zone> zones = store.getZones().stream().filter(z -> z.getZoneName().equalsIgnoreCase(requestZone.getZoneName())).toList();
        List<String> zoneNames = new java.util.ArrayList<>();
        store.getZones().forEach(zone -> zoneNames.add(zone.getZoneName()));

        if(zones.isEmpty()){
            storeRepository.addZone(requestZone);
            zoneNames.add(requestZone.getZoneName());
        }

        return zoneNames;
    }

    public Zone getZone(RequestZone requestZone){
        Store store1 = storeRepository.findStore(requestZone.getName(), requestZone.getEmail());

        return store1.getZones().stream().filter(z -> z.getZoneName().equalsIgnoreCase(requestZone.getZoneName())).toList().get(0);

    }
}
