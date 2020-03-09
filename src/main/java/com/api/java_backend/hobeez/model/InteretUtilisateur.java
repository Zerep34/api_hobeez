package com.api.java_backend.hobeez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(multiKey.class)
public class InteretUtilisateur{

    @Id
    private String id_user;
    @Id
    private int id_interet;

    public InteretUtilisateur() {
    }

    public InteretUtilisateur(String id_user, int id_interet) {
        this.id_user = id_user;
        this.id_interet = id_interet;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public int getId_interet() {
        return id_interet;
    }

    public void setId_interet(int id_interet) {
        this.id_interet = id_interet;
    }

    @Override
    public String toString() {
        return "InteretUtilisateur{" +
                "id_user='" + id_user + '\'' +
                ", id_interet=" + id_interet +
                '}';
    }
}