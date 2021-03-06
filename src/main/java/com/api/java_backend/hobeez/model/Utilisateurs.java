package com.api.java_backend.hobeez.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Utilisateurs {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String email;

    @NotNull
    private String pass;

    @NotNull
    private String full_name;

    @NotNull
    private Date birthday;

    @NotNull
    private boolean hasChild;

    public Utilisateurs() {
    }

    public Utilisateurs(String email, String pass, String full_name, Date birthday, boolean hasChild) {
        this.email = email;
        this.pass = pass;
        this.full_name = full_name;
        this.birthday = birthday;
        this.hasChild = hasChild;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Date getBirthdate() {
        return birthday;
    }

    public void setBirthdate(Date birthday) {
        this.birthday = birthday;
    }

    public boolean hasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    @Override
    public String toString() {
        return "Utilisateurs{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", full_name='" + full_name + '\'' +
                ", birthday=" + birthday +
                ", hasChild=" + hasChild +
                '}';
    }
}
