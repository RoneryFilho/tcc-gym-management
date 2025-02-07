package com.example.tcc_gym_management.dto;

import com.example.tcc_gym_management.entities.Gym;

import java.io.Serializable;

public class GymDTO implements Serializable {
    private String id;
    private String name;
    private String document;
    private String phoneNumber;

    public GymDTO() {

    }

    public GymDTO(Gym gym) {
        this.id = gym.getId();
        this.name = gym.getName();
        this.document = gym.getDocument();
        this.phoneNumber = gym.getPhoneNumber();
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
