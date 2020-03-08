package com.api.java_backend.hobeez.repository;

import com.api.java_backend.hobeez.model.CouponsByUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CouponsByUserRepository extends CrudRepository<CouponsByUser, Integer> {

    @Modifying
    @Query("DELETE from CouponsByUser c WHERE c.id_user=?1 and c.id_coupon=?2")
    void delete(String id_user, int id_coupon);
}