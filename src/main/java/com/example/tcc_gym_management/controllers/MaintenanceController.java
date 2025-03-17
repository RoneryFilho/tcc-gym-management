package com.example.tcc_gym_management.controllers;

import com.example.tcc_gym_management.entities.Maintenance;
import com.example.tcc_gym_management.services.MaintenanceService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/maintenances")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Maintenance maintenance){
        maintenanceService.insert(maintenance);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(maintenance.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> findAll(){
        List<Maintenance> maintenances = maintenanceService.findAll();
        return ResponseEntity.ok(maintenances);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Maintenance> findById(@PathVariable String id){
        Maintenance maintenance = maintenanceService.findById(id);
        return ResponseEntity.ok(maintenance);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Maintenance maintenance){
        Maintenance updatedMaintenance = maintenance;
        maintenanceService.update(updatedMaintenance);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        maintenanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
