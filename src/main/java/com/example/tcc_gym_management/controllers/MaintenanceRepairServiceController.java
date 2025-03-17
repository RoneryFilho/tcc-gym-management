package com.example.tcc_gym_management.controllers;

import com.example.tcc_gym_management.entities.MaintenanceRepairService;
import com.example.tcc_gym_management.services.MaintenanceRepairServiceService;
import com.example.tcc_gym_management.services.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/maintenance-repair-services")
public class MaintenanceRepairServiceController {

    @Autowired
    MaintenanceRepairServiceService maintenanceRepairServiceService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody MaintenanceRepairService maintenanceRepairService){
        maintenanceRepairServiceService.insert(maintenanceRepairService);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(maintenanceRepairService.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRepairService>> findAll(){
        List<MaintenanceRepairService> maintenanceRepairServices = maintenanceRepairServiceService.findAll();
        return ResponseEntity.ok(maintenanceRepairServices);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MaintenanceRepairService> findById(@PathVariable String id){
        MaintenanceRepairService maintenanceRepairService = maintenanceRepairServiceService.findById(id);
        return ResponseEntity.ok(maintenanceRepairService);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody MaintenanceRepairService maintenanceRepairService){
        MaintenanceRepairService updatedMaintenanceRepairService = maintenanceRepairService;
        maintenanceRepairServiceService.update(updatedMaintenanceRepairService);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        maintenanceRepairServiceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
