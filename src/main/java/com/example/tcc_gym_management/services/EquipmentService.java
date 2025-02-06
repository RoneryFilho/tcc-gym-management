package com.example.tcc_gym_management.services;

import com.example.tcc_gym_management.entities.Equipment;
import com.example.tcc_gym_management.repositories.EquipmentRepository;
import com.example.tcc_gym_management.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Equipment findById(String id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);

        return equipment.orElseThrow(() -> new ObjectNotFoundException("Objeto Equipment não encontrado"));
    }

    public Equipment insert(Equipment equipment) {
        return equipmentRepository.insert(equipment);
    }

    public void delete(String id) {
        findById(id);
        equipmentRepository.deleteById(id);
    }

    public Equipment update(Equipment equipment) {
        Equipment updatedEquipment = findById(equipment.getId());
        updateData(updatedEquipment, equipment);
        return equipmentRepository.save(updatedEquipment);
    }

    private void updateData(Equipment newEquipment, Equipment equipment) {
        newEquipment.setId(equipment.getId());
        newEquipment.setName(equipment.getName());
        newEquipment.setDescription(equipment.getDescription());
        newEquipment.setPropertyNumber(equipment.getPropertyNumber());
        newEquipment.setPurchaseDate(equipment.getPurchaseDate());
        newEquipment.setOriginalValue(equipment.getOriginalValue());
        newEquipment.setCurrentValue(equipment.getCurrentValue());
        newEquipment.setDepreciationPercentage(equipment.getDepreciationPercentage());
        newEquipment.setDurability(equipment.getDurability());
        newEquipment.setEquipmentType(equipment.getEquipmentType());
        equipmentRepository.save(newEquipment);
    }
}
