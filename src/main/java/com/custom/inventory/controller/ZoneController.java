package com.custom.inventory.controller;

import com.custom.inventory.model.Zone;
import com.custom.inventory.protocol.RequestZone;
import com.custom.inventory.protocol.Response;
import com.custom.inventory.repository.StoreRepository;
import com.custom.inventory.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
@CrossOrigin
public class ZoneController extends Handler {

    final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @PostMapping("/create")
    private ResponseEntity<Response> createZone(@RequestBody RequestZone requestZone){
        Response response = new Response(zoneService.createZone(requestZone), HttpStatus.OK.value(), HttpStatus.OK.name());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/get")
    private ResponseEntity<Response> getZone(@RequestBody RequestZone requestZone){
        Response response = new Response(zoneService.getZone(requestZone), HttpStatus.OK.value(), HttpStatus.OK.name());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/delete")
    private ResponseEntity<Response> removeZone(@RequestBody RequestZone requestZone){
        zoneService.deleteZone(requestZone);
        Response response = new Response("Deleted", HttpStatus.OK.value(), HttpStatus.OK.name());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
