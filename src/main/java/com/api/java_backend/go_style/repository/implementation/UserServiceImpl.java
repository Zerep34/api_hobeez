package com.api.java_backend.go_style.repository.implementation;

import com.api.java_backend.go_style.model.Utilisateurs;
import com.api.java_backend.go_style.repository.UserRepository;
import com.api.java_backend.go_style.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Utilisateurs findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    @Transactional
    public void update(String email, String pass, String fullname, String oldEmail){
        this.userRepository.update(email,pass, fullname, oldEmail);
    }

    @Override
    public void save(Utilisateurs user){
        this.userRepository.save(user);
    }

    @Override
    public Iterable<Utilisateurs> findAll(){return this.userRepository.findAll();}

}
