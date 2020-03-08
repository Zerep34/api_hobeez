package com.api.java_backend.go_style.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(multiKey.class)
public class CouponsByUser {

    @Id
    private String id_user;
    @Id
    private int id_coupon;

    public CouponsByUser(){}

    public CouponsByUser(String idUser, int idCoupon) {
        this.id_user = idUser;
        this.id_coupon = idCoupon;
    }

    public String getIdUser() {
        return id_user;
    }

    public void setIdUser(String idUser) {
        this.id_user = idUser;
    }

    public int getIdCoupon() {
        return id_coupon;
    }

    public void setIdCoupon(int idCoupon) {
        this.id_coupon = idCoupon;
    }
}