package com.api.java_backend.hobeez.repository.implementation;

import com.api.java_backend.hobeez.model.Coupons;
import com.api.java_backend.hobeez.repository.CouponsRepository;
import com.api.java_backend.hobeez.repository.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CouponImpl implements CouponService {

    private CouponsRepository couponsRepository;

    @Autowired
    public CouponImpl(CouponsRepository couponsRepository) {
        this.couponsRepository = couponsRepository;
    }

    @Override
    public Iterable<Coupons> getCouponsByUser(String idUser) {
        return this.couponsRepository.getCouponsByUser(idUser);
    }

    @Transactional
    public void update(int id, String code_value, Date start_date, Date end_date,
                String description, int reduction_amount, boolean global_value,
                int nb_utilisation, String devise, int oldId){
        this.couponsRepository.update(id, code_value, start_date, end_date, description, reduction_amount, global_value, nb_utilisation, devise, oldId);
    }
}
