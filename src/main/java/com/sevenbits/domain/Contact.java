package com.sevenbits.domain;

import java.io.Serializable;
import java.util.Map;

public class Contact implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void saveFieldsContatcs(Map<String, String> fields) {
        name = fields.get("name");
        surname = fields.get("surname");
        email = fields.get("mail");
    }
}

