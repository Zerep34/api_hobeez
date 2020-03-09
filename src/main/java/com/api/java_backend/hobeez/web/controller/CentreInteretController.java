package com.api.java_backend.hobeez.web.controller;

import com.api.java_backend.hobeez.model.CentreInteret;
import com.api.java_backend.hobeez.repository.CentreInteretRepository;
import com.api.java_backend.hobeez.repository.service.CentreInteretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping(path="api/hobeez/centreinteret")
public class CentreInteretController {

    @Autowired
    CentreInteretRepository centreInteretRepository;

    @Autowired
    CentreInteretService centreInteretService;

    @GetMapping(value="/all")
    public Iterable<CentreInteret> getAllPromo() {
        return centreInteretRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public Optional<CentreInteret> getOnePromo(@PathVariable int id) {
        return centreInteretRepository.findById(id);
    }

    @PostMapping(value="/add")
    public @ResponseBody String save(@RequestParam String code,
                                     @RequestParam String libelle) throws ParseException {
        CentreInteret p = new CentreInteret(Integer.parseInt(code), libelle);
        centreInteretRepository.save(p);
        return "Saved";
    }

    @PutMapping(value="/update/{id}")
    public @ResponseBody String update(@RequestParam String code,
                                                  @RequestParam String libelle,
                                                  @PathVariable String id) throws ParseException {
        if(centreInteretRepository.findById(Integer.parseInt(code)).isPresent()){
            centreInteretService.update(Integer.parseInt(code), libelle, Integer.parseInt(id));
            return "Updated";
        }
        else{
            return "Not in database";
        }
    }

    @DeleteMapping(value="delete/{id}")
    public @ResponseBody String delete(@PathVariable int id){
        if(centreInteretRepository.findById(id).isPresent()){
            centreInteretRepository.deleteById(id);
            return "Deleted";
        }
        else{
            return "Not in the database;";
        }
    }

    @GetMapping(path="/spec/{idUser}")
    public @ResponseBody
    Iterable<CentreInteret> getCouponsById(@PathVariable("idUser") String idUser){
        return centreInteretService.getCentreInteretByUser(idUser);
    }
}
