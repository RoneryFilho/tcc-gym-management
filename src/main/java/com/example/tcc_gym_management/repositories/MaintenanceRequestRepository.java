package com.example.tcc_gym_management.repositories;

import com.example.tcc_gym_management.entities.MaintenanceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRequestRepository extends MongoRepository<MaintenanceRequest, String> {

}
