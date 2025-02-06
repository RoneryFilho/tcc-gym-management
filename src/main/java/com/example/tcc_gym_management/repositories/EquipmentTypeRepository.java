package com.example.tcc_gym_management.repositories;

import com.example.tcc_gym_management.entities.EquipmentType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepository extends MongoRepository<EquipmentType, String> {

}
