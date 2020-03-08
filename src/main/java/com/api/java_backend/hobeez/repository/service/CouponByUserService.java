package com.api.java_backend.hobeez.repository.service;


import com.api.java_backend.hobeez.model.CouponsByUser;

public interface CouponByUserService {

    Iterable<CouponsByUser> findAll();

    void save(String idUser, int idCoupon);

    void delete(String id_user, int id_coupon);

}
