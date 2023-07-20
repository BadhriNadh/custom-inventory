package com.custom.inventory.controller;

import com.custom.inventory.model.Store;
import com.custom.inventory.protocol.RequestStore;
import com.custom.inventory.protocol.Response;
import com.custom.inventory.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
@CrossOrigin
public class StoreController extends Handler {

    final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/open")
    private ResponseEntity<Response> openStore(@RequestBody RequestStore requestStore){
        Response response = storeService.findStore(requestStore);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/create")
    private ResponseEntity<Response> createStore(@RequestBody RequestStore requestStore){
        Response response = storeService.createStore(requestStore);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
