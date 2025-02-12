package com.example.tcc_gym_management.services;

import com.example.tcc_gym_management.entities.EquipmentType;
import com.example.tcc_gym_management.repositories.EquipmentTypeRepository;
import com.example.tcc_gym_management.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentTypeService {
    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    public List<EquipmentType> findAll() {
        return equipmentTypeRepository.findAll();
    }

    public EquipmentType findById(String id) {
        Optional<EquipmentType> equipmentType = equipmentTypeRepository.findById(id);

        return equipmentType.orElseThrow(() -> new ObjectNotFoundException("Objeto EquipmentType não encontrado"));
    }

    public EquipmentType insert(EquipmentType equipmentType) {
        return equipmentTypeRepository.insert(equipmentType);
    }

    public void delete(String id) {
        findById(id);
        equipmentTypeRepository.deleteById(id);
    }

    public void update(EquipmentType equipmentType) {
        EquipmentType updatedEquipmentType = findById(equipmentType.getId());
        updateData(updatedEquipmentType, equipmentType);
        equipmentTypeRepository.save(updatedEquipmentType);
    }

    private void updateData(EquipmentType newEquipmentType, EquipmentType equipmentType) {
        newEquipmentType.setId(equipmentType.getId());
        newEquipmentType.setName(equipmentType.getName());
        newEquipmentType.setDescription(equipmentType.getDescription());
        equipmentTypeRepository.save(newEquipmentType);
    }
}
