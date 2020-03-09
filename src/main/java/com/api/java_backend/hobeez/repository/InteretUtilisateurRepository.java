package com.api.java_backend.hobeez.repository;

import com.api.java_backend.hobeez.model.InteretUtilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InteretUtilisateurRepository extends CrudRepository<InteretUtilisateur, Integer> {

    @Modifying
    @Query("DELETE from InteretUtilisateur c WHERE c.id_user=?1 and c.id_interet=?2")
    void delete(String id_user, int id_coupon);
}