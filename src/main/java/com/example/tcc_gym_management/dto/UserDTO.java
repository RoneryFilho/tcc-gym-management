package com.example.tcc_gym_management.dto;

import com.example.tcc_gym_management.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String userName;
    private String email;
    private String document;
    private String phoneNumber;
    private GymDTO gymDTO;

    public UserDTO() {

    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.document = user.getDocument();
        this.phoneNumber = user.getPhoneNumber();
        this.gymDTO = user.getGymDTO();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public GymDTO getGymDTO() {
        return gymDTO;
    }

    public void setGymDTO(GymDTO gymDTO) {
        this.gymDTO = gymDTO;
    }
}
