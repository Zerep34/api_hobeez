package com.api.java_backend.hobeez.repository;

import com.api.java_backend.hobeez.model.Utilisateurs;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface UserRepository extends CrudRepository<Utilisateurs, Integer> {

    @Query("SELECT u from Utilisateurs u Where u.email=?1")
    Utilisateurs findByEmail(String email);

    @Modifying
    @Query("DELETE from Utilisateurs u WHERE u.email=?1")
    void deleteByEmail(String email);

    @Modifying
    @Query("Update Utilisateurs Set email=?1, pass=?2, full_name=?3, birthday=?4 Where email=?5")
    void update(String email, String pass, String fullname, Date birthDate, String oldEmail);
}
