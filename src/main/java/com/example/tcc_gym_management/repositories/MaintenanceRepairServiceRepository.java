package com.example.tcc_gym_management.repositories;

import com.example.tcc_gym_management.dto.MaintenanceDTO;
import com.example.tcc_gym_management.entities.MaintenanceRepairService;
import com.example.tcc_gym_management.services.MaintenanceRequestService;
import com.example.tcc_gym_management.services.MaintenanceService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepairServiceRepository extends MongoRepository<MaintenanceRepairService, String> {
    public List<MaintenanceRepairService> findByMaintenance(MaintenanceDTO maintenance);
}
