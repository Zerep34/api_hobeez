package com.api.java_backend.hobeez.web.controller;

import com.api.java_backend.hobeez.model.Utilisateurs;
import com.api.java_backend.hobeez.repository.UserRepository;
import com.api.java_backend.hobeez.repository.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping(path="api/hobeez/user")
public class UtilisateurController {

    String API_KEY = "AIzaSyCL1grfGNMygaod44vtCJQWZSShgweACY0";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String fullname,
                                           @RequestParam String birthdate,
                                           @RequestParam String hasChild) throws Exception {
        Date birth = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
        boolean hasChild_temp;
        if(hasChild.equals("true")){
            hasChild_temp = true;
        }else{
            hasChild_temp = false;
        }
        Utilisateurs u = new Utilisateurs(email, password, fullname, birth, hasChild_temp);
        userService.save(u);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Utilisateurs> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/{email}")
    public @ResponseBody
    Utilisateurs getById(@PathVariable String email) throws Exception {
        return userService.findByEmail(email);
    }

    @DeleteMapping(value = "/delete/{email}")
    public @ResponseBody String delete(@PathVariable String email){
        if(userRepository.findByEmail(email) != null){
            userService.deleteByEmail(email);
            return "Deleted";
        }
        else{
            return "User does not exist";
        }
    }

    @PutMapping(path="/update/{oldemail}")
    public @ResponseBody
    String update(@RequestParam String email,
                  @RequestParam String password,
                  @RequestParam String fullname,
                  @RequestParam String birthdate,
                  @RequestParam String hasChild,
                  @PathVariable String oldemail) throws ParseException {

        Date birth = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
        String hasChild_temp;
        if(hasChild.equals("true")){
            hasChild_temp = "true";
        }else{
            hasChild_temp = "false";
        }
        if(userRepository.findByEmail(email) != null){
            userService.update(email, password, fullname, birth, hasChild_temp, oldemail);
            return "Updated";
        }
        else{
            return "User does not exist";
        }
    }
}
