package com.api.java_backend.hobeez.repository.implementation;

import com.api.java_backend.hobeez.model.Utilisateurs;
import com.api.java_backend.hobeez.repository.UserRepository;
import com.api.java_backend.hobeez.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Utilisateurs findByEmail(String email) throws Exception {
        Utilisateurs u = userRepository.findByEmail(email);
        if(u != null){
            return u;
        }
        throw new Exception("Not Found");
    }

    @Transactional
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Transactional
    public void update(String email, String pass, String fullname, Date birthdate, String hasChild, String oldEmail){
        this.userRepository.update(email,pass, fullname, birthdate, hasChild, oldEmail);
    }

    @Override
    public Utilisateurs save(Utilisateurs user) throws Exception {
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new Exception("User already exists");
        }
        this.userRepository.save(user);
        return user;
    }

    @Override
    public Iterable<Utilisateurs> findAll(){return this.userRepository.findAll();}

}
