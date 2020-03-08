package com.api.java_backend.hobeez.web.controller;

import com.api.java_backend.hobeez.model.Coupons;
import com.api.java_backend.hobeez.repository.CouponsRepository;
import com.api.java_backend.hobeez.repository.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path="api/coupon")
public class CouponController {

    @Autowired
    CouponsRepository couponsRepository;

    @Autowired
    CouponService couponService;

    @GetMapping(value="/all")
    public Iterable<Coupons> getAllPromo() {
        return couponsRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public Optional<Coupons> getOnePromo(@PathVariable int id) {
        return couponsRepository.findById(id);
    }

    @PostMapping(value="/add")
    public @ResponseBody String save(@RequestParam String code,
                                     @RequestParam String code_value,
                                     @RequestParam String startDate,
                                     @RequestParam String endDate,
                                     @RequestParam String description,
                                     @RequestParam String reductionAmount,
                                     @RequestParam String global,
                                     @RequestParam String nbUtilisation,
                                     @RequestParam String devise) throws ParseException {
        Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        boolean global_temp;
        if(global.equals("true")){
            global_temp = true;
        }else{
            global_temp = false;
        }
        Coupons p = new Coupons(Integer.parseInt(code), code_value, d1, d2, description, Integer.parseInt(reductionAmount), global_temp, Integer.parseInt(nbUtilisation), devise);
        couponsRepository.save(p);
        return "Saved";
    }

    @PutMapping(value="/update/{id}")
    public @ResponseBody String update(@RequestParam String code,
                                                  @RequestParam String code_value,
                                                  @RequestParam String startDate,
                                                  @RequestParam String endDate,
                                                  @RequestParam String description,
                                                  @RequestParam String reductionAmount,
                                                  @RequestParam String global,
                                                  @RequestParam String nbUtilisation,
                                                  @RequestParam String devise,
                                                  @PathVariable String id) throws ParseException {
        Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        boolean global_temp;
        if(global.equals("true")){
            global_temp = true;
        }else{
            global_temp = false;
        }
        if(couponsRepository.findById(Integer.parseInt(code)).isPresent()){
            couponService.update(Integer.parseInt(code), code_value, d1, d2, description, Integer.parseInt(reductionAmount), global_temp, Integer.parseInt(nbUtilisation), devise, Integer.parseInt(id));
            return "Updated";
        }
        else{
            return "Not in database";
        }
    }

    @DeleteMapping(value="delete/{id}")
    public @ResponseBody String delete(@PathVariable int id){
        if(couponsRepository.findById(id).isPresent()){
            couponsRepository.deleteById(id);
            return "Deleted";
        }
        else{
            return "Not in the database;";
        }
    }

    @GetMapping(path="/spec/{idUser}")
    public @ResponseBody
    Iterable<Coupons> getCouponsById(@PathVariable("idUser") String idUser){
        return couponService.getCouponsByUser(idUser);
    }
}
