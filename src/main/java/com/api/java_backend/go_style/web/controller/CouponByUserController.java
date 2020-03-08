package com.api.java_backend.go_style.web.controller;

import com.api.java_backend.go_style.model.CouponsByUser;
import com.api.java_backend.go_style.repository.service.CouponByUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="api/couponbyuser")
@Slf4j
public class CouponByUserController {

    @Autowired
    CouponByUserService couponByUserService;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewLink(@RequestParam String idUser,
                      @RequestParam String idCoupon){
        couponByUserService.save(idUser, Integer.parseInt(idCoupon));
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CouponsByUser> getAllUsers(){
        return couponByUserService.findAll();
    }

    @DeleteMapping(path="/delete/{idUser}&{idCoupon}")
    public @ResponseBody String delete(@PathVariable String idUser,
                                       @PathVariable String idCoupon){
        couponByUserService.delete(idUser, Integer.parseInt(idCoupon));
        return "Deleted";
    }

}
