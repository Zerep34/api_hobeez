package com.api.java_backend.go_style.repository.service;

import com.api.java_backend.go_style.model.Utilisateurs;

public interface UserService {

    Utilisateurs findByEmail(String email);

    void deleteByEmail(String email);

    void update(String email, String pass, String fullname, String oldEmail);

    void save(Utilisateurs user);

    Iterable<Utilisateurs> findAll();
}
