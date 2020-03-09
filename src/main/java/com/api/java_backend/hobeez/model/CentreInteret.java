package com.api.java_backend.hobeez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CentreInteret {

    @Id
    private int id;

    @NotNull
    private String libelle;

    public CentreInteret() {
    }

    public CentreInteret(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String   toString() {
        return "CentreInteret{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
