package com.api.java_backend.hobeez.web.controller;

import com.api.java_backend.hobeez.model.Utilisateurs;
import com.api.java_backend.hobeez.repository.UserRepository;
import com.api.java_backend.hobeez.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="api/user")
public class UtilisateurController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String fullname){
        Utilisateurs u = new Utilisateurs(email, password, fullname);
        userService.save(u);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Utilisateurs> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/{email}")
    public @ResponseBody
    Utilisateurs getById(@PathVariable String email){
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
                  @PathVariable String oldemail){

        if(userRepository.findByEmail(email) != null){
            userService.update(email, password, fullname, oldemail);
            return "Updated";
        }
        else{
            return "User does not exist";
        }
    }
}
