package com.example.tcc_gym_management.repositories;

import com.example.tcc_gym_management.entities.Maintenance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends MongoRepository<Maintenance, String> {

}
