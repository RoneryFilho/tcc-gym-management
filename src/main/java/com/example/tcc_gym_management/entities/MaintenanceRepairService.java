package com.example.tcc_gym_management.entities;

import com.example.tcc_gym_management.dto.MaintenanceRequestDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "maintenance-services")
public class MaintenanceRepairService implements Serializable {

    @Id
    private String id;
    private Maintenance maintenance;
    private MaintenanceRequestDTO maintenanceRequestDTO;
    private String description;
    private Double subTotal;
    private Double finalPrice;
    private List<Equipment> equipmentList = new ArrayList<>();

    public MaintenanceRepairService() {

    }

    public MaintenanceRepairService(String id, Maintenance maintenance, MaintenanceRequest maintenanceRequest, List<Equipment> equipmentList, String description, Double subTotal) {
        this.id = id;
        this.maintenance = maintenance;
        this.maintenanceRequestDTO = new MaintenanceRequestDTO(maintenanceRequest);
        this.equipmentList = equipmentList;
        this.description = description;
        this.subTotal = subTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public MaintenanceRequestDTO getMaintenanceRequestDTO() {
        return maintenanceRequestDTO;
    }

    public void setMaintenanceRequestDTO(MaintenanceRequestDTO maintenanceRequestDTO) {
        this.maintenanceRequestDTO = maintenanceRequestDTO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceRepairService service = (MaintenanceRepairService) o;
        return Objects.equals(id, service.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
