package com.example.tcc_gym_management.controllers;

import com.example.tcc_gym_management.entities.Equipment;
import com.example.tcc_gym_management.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Equipment equipment){
        equipmentService.insert(equipment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id").buildAndExpand(equipment.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> findAll(){
        List<Equipment> equipmentList = equipmentService.findAll();
        return ResponseEntity.ok(equipmentList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipment> findById(@PathVariable String id){
        Equipment equipment = equipmentService.findById(id);
        return ResponseEntity.ok(equipment);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Equipment equipment){
        Equipment updatedEquipment = equipment;
        equipmentService.update(updatedEquipment);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        equipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
