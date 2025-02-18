package com.example.tcc_gym_management.dto;

import com.example.tcc_gym_management.entities.MaintenanceRequest;

import java.util.Date;

public class MaintenanceRequestDTO {

    private String id;
    private Long requestNumber;
    private String createdAt;

    public MaintenanceRequestDTO() {

    }

    public MaintenanceRequestDTO(MaintenanceRequest maintenanceRequest) {
        this.id = maintenanceRequest.getId();
        this.requestNumber = maintenanceRequest.getRequestNumber();
        this.createdAt = maintenanceRequest.getCreatedAt();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Long requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
