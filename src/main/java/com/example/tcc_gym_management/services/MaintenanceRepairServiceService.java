package com.example.tcc_gym_management.services;

import com.example.tcc_gym_management.dto.MaintenanceDTO;
import com.example.tcc_gym_management.entities.Maintenance;
import com.example.tcc_gym_management.entities.MaintenanceRepairService;
import com.example.tcc_gym_management.repositories.MaintenanceRepairServiceRepository;
import com.example.tcc_gym_management.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRepairServiceService {

    @Autowired
    private MaintenanceRepairServiceRepository maintenanceRepairServiceRepository;

    public List<MaintenanceRepairService> findAll() {
        return maintenanceRepairServiceRepository.findAll();
    }

    public MaintenanceRepairService findById(String id) {
        Optional<MaintenanceRepairService> maintenanceRepairService = maintenanceRepairServiceRepository.findById(id);

        return maintenanceRepairService.orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado"));
    }

    public List<MaintenanceRepairService> findByMaintenance(Maintenance maintenance) {
        MaintenanceDTO maintenanceDto = new MaintenanceDTO(maintenance);
        return maintenanceRepairServiceRepository.findByMaintenance(maintenanceDto);
    }

    public void insert(MaintenanceRepairService maintenanceService) {
        maintenanceRepairServiceRepository.insert(maintenanceService);
    }

    public void deleteById(String id){
        maintenanceRepairServiceRepository.findById(id);
        maintenanceRepairServiceRepository.deleteById(id);
    }

    public void update(MaintenanceRepairService repairService) {
        MaintenanceRepairService updatedRepairService = findById(repairService.getId());
        updateData(updatedRepairService, repairService);
        maintenanceRepairServiceRepository.save(updatedRepairService);
    }

    public void updateData(MaintenanceRepairService newMaintenanceService, MaintenanceRepairService oldMaintenanceService) {
        newMaintenanceService.setId(oldMaintenanceService.getId());
        newMaintenanceService.setMaintenance(oldMaintenanceService.getMaintenance());
        newMaintenanceService.setMaintenanceRequestDTO(oldMaintenanceService.getMaintenanceRequestDTO());
        newMaintenanceService.setDescription(oldMaintenanceService.getDescription());
        newMaintenanceService.setSubTotal(oldMaintenanceService.getSubTotal());
        newMaintenanceService.setFinalPrice(oldMaintenanceService.getFinalPrice());
    }
}
