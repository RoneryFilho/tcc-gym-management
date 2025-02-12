package com.example.tcc_gym_management.services;

import com.example.tcc_gym_management.entities.Maintenance;
import com.example.tcc_gym_management.repositories.MaintenanceRepository;
import com.example.tcc_gym_management.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    @Autowired
    MaintenanceRepository maintenanceRepository;

    public List<Maintenance> findAll(){
        return maintenanceRepository.findAll();
    }

    public Maintenance findById(String id){
        Optional<Maintenance> maintenance = maintenanceRepository.findById(id);

        return maintenance.orElseThrow(() -> new ObjectNotFoundException("Objeto Maintenance não encontrado"));
    }

    public Maintenance insert(Maintenance maintenance){
        return maintenanceRepository.insert(maintenance);
    }

    public void deleteById(String id){
        findById(id);
        maintenanceRepository.deleteById(id);
    }

    public void update(Maintenance maintenance){
        Maintenance updatedMaintenance = findById(maintenance.getId());
        updateData(updatedMaintenance, maintenance);
        maintenanceRepository.save(updatedMaintenance);
    }

    private void updateData(Maintenance newMaintenance, Maintenance oldMaintenance){
        newMaintenance.setId(oldMaintenance.getId());
        newMaintenance.setName(oldMaintenance.getName());
        newMaintenance.setDocument(oldMaintenance.getDocument());
        newMaintenance.setPhoneNumber(oldMaintenance.getPhoneNumber());
        newMaintenance.setEmail(oldMaintenance.getEmail());
        newMaintenance.setAddress(oldMaintenance.getAddress());
        newMaintenance.setContactEmployee(oldMaintenance.getContactEmployee());
    }
}
