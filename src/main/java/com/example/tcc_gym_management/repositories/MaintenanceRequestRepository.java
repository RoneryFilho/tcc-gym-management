package com.example.tcc_gym_management.repositories;

import com.example.tcc_gym_management.entities.Maintenance;
import com.example.tcc_gym_management.entities.MaintenanceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRequestRepository extends MongoRepository<MaintenanceRequest, String> {
    public MaintenanceRequest findByRequestNumber(Long requestNumber);
//    public MaintenanceRequest findByMaintenance(Maintenance maintenance);
}
