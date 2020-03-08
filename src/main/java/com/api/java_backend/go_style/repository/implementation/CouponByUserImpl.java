package com.api.java_backend.go_style.repository.implementation;

import com.api.java_backend.go_style.model.CouponsByUser;
import com.api.java_backend.go_style.repository.CouponsByUserRepository;
import com.api.java_backend.go_style.repository.service.CouponByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponByUserImpl implements CouponByUserService {

    private CouponsByUserRepository couponsByUserRepository;

    @Autowired
    public CouponByUserImpl(CouponsByUserRepository couponsByUserRepository) {
        this.couponsByUserRepository = couponsByUserRepository;
    }

    @Override
    @Transactional
    public void delete(String id_user, int id_coupon) {
        couponsByUserRepository.delete(id_user, id_coupon);
    }

    @Override
    public Iterable<CouponsByUser> findAll() {
        return couponsByUserRepository.findAll();
    }

    public void save(String idUser, int idCoupon) {
        CouponsByUser cp = new CouponsByUser(idUser, idCoupon) {
        };
        couponsByUserRepository.save(cp);
    }

}
