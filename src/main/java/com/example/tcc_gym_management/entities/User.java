package com.example.tcc_gym_management.entities;

import com.example.tcc_gym_management.dto.GymDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String document;
    private String email;
    private String phoneNumber;
    private GymDTO gymDTO;

    public User() {

    }

    public User(String id, String name, String document, String email, String phoneNumber) {
        super();
        this.name = name;
        this.document = document;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
