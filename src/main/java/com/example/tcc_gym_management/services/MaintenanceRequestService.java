package com.example.tcc_gym_management.services;

import com.example.tcc_gym_management.entities.MaintenanceRequest;
import com.example.tcc_gym_management.repositories.MaintenanceRequestRepository;
import com.example.tcc_gym_management.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestService {

    @Autowired
    MaintenanceRequestRepository maintenanceRequestRepository;

    public List<MaintenanceRequest> findAll(){
        return maintenanceRequestRepository.findAll();
    }

    public MaintenanceRequest findById(String id){
        Optional<MaintenanceRequest> maintenanceRequest = maintenanceRequestRepository.findById(id);

        return maintenanceRequest.orElseThrow(() -> new ObjectNotFoundException("Objeto MaintenanceRequest não encontrado"));
    }

    public MaintenanceRequest findByRequestNumber(Long requestNumber){
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepository.findByRequestNumber(requestNumber);

        return maintenanceRequest;
    }

    public MaintenanceRequest insert(MaintenanceRequest maintenanceRequest){
        return maintenanceRequestRepository.insert(maintenanceRequest);
    }

    public void delete(String id){
        findById(id);
        maintenanceRequestRepository.deleteById(id);
    }

    public void update(MaintenanceRequest maintenanceRequest){
        MaintenanceRequest updatedMaintenanceRequest = findById(maintenanceRequest.getId());
        updateData(updatedMaintenanceRequest, maintenanceRequest);
        maintenanceRequestRepository.save(updatedMaintenanceRequest);
    }

    private void updateData(MaintenanceRequest newMaintenanceRequest, MaintenanceRequest oldMaintenanceRequest){
        newMaintenanceRequest.setId(oldMaintenanceRequest.getId());
        newMaintenanceRequest.setRequestNumber(oldMaintenanceRequest.getRequestNumber());
        newMaintenanceRequest.setDescription(oldMaintenanceRequest.getDescription());
        newMaintenanceRequest.setEquipments(oldMaintenanceRequest.getEquipments());
        newMaintenanceRequest.setConditions(oldMaintenanceRequest.getConditions());
        newMaintenanceRequest.setUserDTO(oldMaintenanceRequest.getUserDTO());
    }
}
