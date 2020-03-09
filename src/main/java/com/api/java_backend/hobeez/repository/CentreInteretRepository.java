package com.api.java_backend.hobeez.repository;

import com.api.java_backend.hobeez.model.CentreInteret;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CentreInteretRepository extends CrudRepository<CentreInteret, Integer> {

    @Query(value = "SELECT c.* from CentreInteret c Join InteretUtilisateur interet on interet.id_interet=c.id Where interet.id_user=?1", nativeQuery = true)
    Iterable<CentreInteret> getCentreInteretByUser(String idUser);

    @Modifying
    @Query(value = "Update CentreInteret c Set c.id=?1, c.libelle=?2  Where c.id=?3")
    void update(int id, String libelle, int oldId);
}
