package com.api.java_backend.go_style.repository.service;


import com.api.java_backend.go_style.model.CouponsByUser;

public interface CouponByUserService {

    Iterable<CouponsByUser> findAll();

    void save(String idUser, int idCoupon);

    void delete(String id_user, int id_coupon);

}
