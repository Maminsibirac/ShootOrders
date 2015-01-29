package com.sevenbits.models;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name", nullable=false, length = 30)
    private String name;

    @Column(name="surname", nullable=false, length = 30)
    private String surname;

    @Column(name="email", nullable=false, length = 30)
    private String email;

    public User(){}

    public User(Map<String, String> fields) {
        name = fields.get("name");
        surname = fields.get("surname");
        email = fields.get("mail");
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
