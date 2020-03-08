package com.api.java_backend.hobeez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Utilisateurs {


    @Id
    private String email;

    @NotNull
    private String pass;

    @NotNull
    private String full_name;

    public Utilisateurs(){}

    public Utilisateurs(String email, String password, String fullName) {
        this.email = email;
        this.pass = password;
        this.full_name = fullName;

    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String fullName) {
        this.full_name = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    @Override
    public String toString() {
        return "Utilisateurs{" +
                " email='" + email + '\'' +
                ", password='" + pass + '\'' +
                ", fullName='" + full_name + '\'' +
                '}';
    }
}
