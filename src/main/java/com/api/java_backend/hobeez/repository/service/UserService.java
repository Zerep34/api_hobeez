package com.api.java_backend.hobeez.repository.service;

import com.api.java_backend.hobeez.model.Utilisateurs;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface UserService {

    Utilisateurs findByEmail(String email) throws Exception;

    void deleteByEmail(String email);

    void update(String email, String pass, String fullname, Date birthDate, String oldEmail);

    Utilisateurs save(Utilisateurs user) throws Exception;

    Iterable<Utilisateurs> findAll();
}
