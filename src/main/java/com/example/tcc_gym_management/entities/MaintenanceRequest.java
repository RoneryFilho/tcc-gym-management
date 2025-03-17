package com.example.tcc_gym_management.entities;

import com.example.tcc_gym_management.dto.MaintenanceDTO;
import com.example.tcc_gym_management.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.*;

@Document(collection = "maintenance-request")
public class MaintenanceRequest implements Serializable {

    @Id
    private String id;
    private Long requestNumber;
    private String description;
    private String observation;
    private String createdAt;
    private Date updatedAt;
    private Date closedAt;
    private MaintenanceDTO maintenanceDTO;
    private UserDTO userDTO;

    private List<Equipment> equipments = new ArrayList<>();
    private List<MaintenanceDTO> maintenances = new ArrayList<>();
    private List<MaintenanceRepairService> services = new ArrayList<>();
    private List<String> conditions = new ArrayList<>();

    public MaintenanceRequest() {

    }

    public MaintenanceRequest(String id, long requestNumber, String description, String observation, Maintenance maintenance, String createdAt, UserDTO userDTO, List<Equipment> equipments, List<String> conditions) {
        this.id = id;
        this.requestNumber = requestNumber;
        this.description = description;
        this.observation = observation;
        this.maintenanceDTO = new MaintenanceDTO(maintenance);
        this.createdAt = createdAt;
        this.userDTO = userDTO;
        this.equipments = equipments;
        this.conditions = conditions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public Long getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Long requestNumber) {
        this.requestNumber = requestNumber;
    }

    public List<MaintenanceRepairService> getServices() {
        return services;
    }

    public void setServices(List<MaintenanceRepairService> services) {
        this.services = services;
    }

    public List<MaintenanceDTO> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<MaintenanceDTO> maintenances) {
        this.maintenances = maintenances;
    }

    public MaintenanceDTO getMaintenanceDTO() {
        return maintenanceDTO;
    }

    public void setMaintenanceDTO(MaintenanceDTO maintenanceDTO) {
        this.maintenanceDTO = maintenanceDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceRequest that = (MaintenanceRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
