package com.example.tcc_gym_management.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "maintenance")
public class Maintenance implements Serializable {

    @Id
    private String id;
    private String name;
    private String document;
    private String phoneNumber;
    private String email;
    private String address;
    private String contactEmployee;

    public Maintenance() {

    }

    public Maintenance(String name, String document, String phoneNumber, String email, String address, String contactEmployee) {
        this.name = name;
        this.document = document;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.contactEmployee = contactEmployee;
    }

    public String getId() {
        return id;
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

    public String getContactEmployee() {
        return contactEmployee;
    }

    public void setContactEmployee(String contactEmployee) {
        this.contactEmployee = contactEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maintenance that = (Maintenance) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
