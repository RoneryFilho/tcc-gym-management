package com.example.tcc_gym_management.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "gym")
public class Gym implements Serializable {

    @Id
    private String id;
    private String name;
    private String document;
    private String phoneNumber;
    private String email;
    private String address;

    public Gym() {

    }

    public Gym(String name, String document, String phoneNumber, String email, String address) {
        this.name = name;
        this.document = document;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gym gym = (Gym) o;
        return Objects.equals(id, gym.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
