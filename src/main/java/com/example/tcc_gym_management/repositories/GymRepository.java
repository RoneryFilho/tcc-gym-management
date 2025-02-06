package com.example.tcc_gym_management.repositories;

import com.example.tcc_gym_management.entities.Gym;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends MongoRepository<Gym, String> {

}
