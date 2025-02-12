package com.example.tcc_gym_management.entities;

import com.example.tcc_gym_management.dto.MaintenanceDTO;
import com.example.tcc_gym_management.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Document(collection = "maintenance-request")
public class MaintenanceRequest implements Serializable {

    @Id
    private String id;
    private String title;
    private String description;
    private String observation;
    private MaintenanceDTO maintenanceDTO;
    private UserDTO userDTO;

    private List<Equipment> equipments = new ArrayList<>();
    private List<String> conditions = new ArrayList<>();

    public MaintenanceRequest() {

    }

    public MaintenanceRequest(String id,String title, String description, String observation, Maintenance maintenance, UserDTO userDTO, List<Equipment> equipments, List<String> conditions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.observation = observation;
        this.maintenanceDTO = new MaintenanceDTO(maintenance);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
