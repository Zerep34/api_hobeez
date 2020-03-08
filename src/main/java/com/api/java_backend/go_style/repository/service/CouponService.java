package com.api.java_backend.go_style.repository.service;

import com.api.java_backend.go_style.model.Coupons;

import java.util.Date;

public interface CouponService {

    Iterable<Coupons> getCouponsByUser(String idUser);

    void update(int id, String code_value, Date start_date, Date end_date,
                String description, int reduction_amount, boolean global_value,
                int nb_utilisation, String devise, int oldId);
}
