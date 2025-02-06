package com.example.tcc_gym_management.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "equipment")
public class Equipment implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private String propertyNumber;
    private Date purchaseDate;
    private Double originalValue;
    private Double currentValue;
    private Double depreciationPercentage;
    private Double durability;
    private EquipmentType equipmentType;

    public Equipment() {

    }

    public Equipment(String id,String name, String description, String propertyNumber, Date purchaseDate, Double originalValue, Double currentValue,
                     Double depreciationPercentage, Double durability, EquipmentType equipmentType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.propertyNumber = propertyNumber;
        this.purchaseDate = purchaseDate;
        this.originalValue = originalValue;
        this.currentValue = currentValue;
        this.depreciationPercentage = depreciationPercentage;
        this.durability = durability;
        this.equipmentType = equipmentType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(Double originalValue) {
        this.originalValue = originalValue;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Double getDepreciationPercentage() {
        return depreciationPercentage;
    }

    public void setDepreciationPercentage(Double depreciationPercentage) {
        this.depreciationPercentage = depreciationPercentage;
    }

    public Double getDurability() {
        return durability;
    }

    public void setDurability(Double durability) {
        this.durability = durability;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
