package com.api.java_backend.hobeez.model;

import java.io.Serializable;


public class multiKey implements Serializable {
    private String id_user;
    private int id_coupon;

    public multiKey(String idUser, int idCoupon) {
        this.id_user = idUser;
        this.id_coupon = idCoupon;
    }

    public multiKey(){}
}
