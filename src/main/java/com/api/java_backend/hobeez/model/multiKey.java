package com.api.java_backend.hobeez.model;

import java.io.Serializable;


public class multiKey implements Serializable {
    private String id_user;
    private int id_interet;

    public multiKey(String idUser, int id_interet) {
        this.id_user = idUser;
        this.id_interet = id_interet;
    }

    public multiKey(){}

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
}
