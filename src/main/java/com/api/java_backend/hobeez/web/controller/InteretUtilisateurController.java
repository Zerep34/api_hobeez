package com.api.java_backend.hobeez.web.controller;

import com.api.java_backend.hobeez.model.InteretUtilisateur;
import com.api.java_backend.hobeez.repository.service.InteretUtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="api/hobeez/couponbyuser")
@Slf4j
public class InteretUtilisateurController {

    @Autowired
    InteretUtilisateurService interetUtilisateurService;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewLink(@RequestParam String idUser,
                      @RequestParam String idCoupon){
        interetUtilisateurService.save(idUser, Integer.parseInt(idCoupon));
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<InteretUtilisateur> getAllUsers(){
        return interetUtilisateurService.findAll();
    }

    @DeleteMapping(path="/delete/{idUser}&{idCoupon}")
    public @ResponseBody String delete(@PathVariable String idUser,
                                       @PathVariable String idCoupon){
        interetUtilisateurService.delete(idUser, Integer.parseInt(idCoupon));
        return "Deleted";
    }

}
