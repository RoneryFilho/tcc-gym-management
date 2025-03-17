package com.example.tcc_gym_management.controllers;

import com.example.tcc_gym_management.dto.MaintenanceDTO;
import com.example.tcc_gym_management.entities.MaintenanceRequest;
import com.example.tcc_gym_management.services.MaintenanceRequestService;
import com.example.tcc_gym_management.services.MaintenanceService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/requests")
public class MaintenanceRequestController {

    @Autowired
    private MaintenanceRequestService maintenanceRequestService;
    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> findAll() {
        List<MaintenanceRequest> requests = maintenanceRequestService.findAll();
        return ResponseEntity.ok().body(requests);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MaintenanceRequest> findById(@PathVariable String id) {
        MaintenanceRequest maintenanceRequest = maintenanceRequestService.findById(id);
        return ResponseEntity.ok().body(maintenanceRequest);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody MaintenanceRequest maintenanceRequest) {
        maintenanceRequestService.insert(maintenanceRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id").buildAndExpand(maintenanceRequest.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody MaintenanceRequest maintenanceRequest) {
        MaintenanceRequest updatedMaintenanceRequest = maintenanceRequest;
        maintenanceRequestService.update(updatedMaintenanceRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        maintenanceRequestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
