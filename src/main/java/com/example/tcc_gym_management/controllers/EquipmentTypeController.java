package com.example.tcc_gym_management.controllers;

import com.example.tcc_gym_management.entities.EquipmentType;
import com.example.tcc_gym_management.services.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/equipment-types")
public class EquipmentTypeController {

    @Autowired
    EquipmentTypeService equipmentTypeService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody EquipmentType equipmentType){
        equipmentTypeService.insert(equipmentType);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id").buildAndExpand(equipmentType.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<EquipmentType>> findAll(){
        List<EquipmentType> equipmentTypes = equipmentTypeService.findAll();
        return ResponseEntity.ok(equipmentTypes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentType> findById(@PathVariable String id){
        EquipmentType equipmentType = equipmentTypeService.findById(id);
        return ResponseEntity.ok(equipmentType);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody EquipmentType equipmentType){
        EquipmentType updatedEquipmentType = equipmentType;
        equipmentTypeService.update(equipmentType);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        equipmentTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
