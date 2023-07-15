package com.custom.inventory.controller;

import com.custom.inventory.model.Store;
import com.custom.inventory.protocol.RequestStore;
import com.custom.inventory.protocol.Response;
import com.custom.inventory.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/open")
    private ResponseEntity<Response> openStore(@RequestBody RequestStore requestStore){

        return ResponseEntity.status(HttpStatus.OK).body(storeService.findStore(requestStore));
    }

    @PostMapping("/create")
    private ResponseEntity<Response> createStore(@RequestBody RequestStore requestStore){
        List<String> zoneNames = storeService.createStore(requestStore);
        Response response = new Response(zoneNames, HttpStatus.CREATED.value(), HttpStatus.CREATED.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
