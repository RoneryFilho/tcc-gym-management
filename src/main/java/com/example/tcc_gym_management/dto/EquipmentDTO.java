package com.example.tcc_gym_management.dto;

import com.example.tcc_gym_management.entities.EquipmentType;

import java.io.Serializable;

public class EquipmentDTO implements Serializable {

    private String id;
    private String name;
    private String propertyNumber;
    private String description;
    private Double currentValue;
    private EquipmentType equipmentType;

    public EquipmentDTO() {

    }

    public EquipmentDTO(String id, String name, String propertyNumber, String description, Double currentValue, EquipmentType type) {
        super();
        this.id = id;
        this.name = name;
        this.propertyNumber = propertyNumber;
        this.description = description;
        this.currentValue = currentValue;
        this.equipmentType = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
}
