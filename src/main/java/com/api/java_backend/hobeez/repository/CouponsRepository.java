package com.api.java_backend.hobeez.repository;

import com.api.java_backend.hobeez.model.Coupons;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface CouponsRepository extends CrudRepository<Coupons, Integer> {

    @Query(value = "SELECT c.* from Coupons c Join CouponsByUser cbu on cbu.id_coupon=c.id Where cbu.id_user=?1", nativeQuery = true)
    Iterable<Coupons> getCouponsByUser(String idUser);

    @Modifying
    @Query(value = "Update Coupons c Set c.id=?1, c.code_value=?2, c.start_date=?3, c.end_date=?4, c.description=?5, c.reduction_amount=?6, c.global_value=?7, c.nb_utilisation=?8, c.devise=?9 Where c.id=?10")
    void update(int id, String code_value, Date start_date, Date end_date, String description, int reduction_amount, boolean global_value, int nb_utilisation, String devise, int oldId);
}
