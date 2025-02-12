package com.example.tcc_gym_management.controllers;

import com.example.tcc_gym_management.entities.Gym;
import com.example.tcc_gym_management.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @GetMapping
    public ResponseEntity<List<Gym>> findAll(){
        List<Gym> gyms = gymService.findAll();
        return ResponseEntity.ok().body(gyms);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Gym> findById(@PathVariable String id){
        Gym gym = gymService.findById(id);
        return ResponseEntity.ok().body(gym);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Gym gym){
        gymService.insert(gym);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id").buildAndExpand(gym.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        gymService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Gym gym){
        Gym updatedGym = gym;
        gymService.update(updatedGym);
        return ResponseEntity.noContent().build();
    }
}
