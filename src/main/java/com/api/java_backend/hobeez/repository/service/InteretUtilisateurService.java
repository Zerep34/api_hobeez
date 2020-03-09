package com.api.java_backend.hobeez.repository.service;


import com.api.java_backend.hobeez.model.InteretUtilisateur;
import org.springframework.stereotype.Service;

@Service
public interface InteretUtilisateurService {

    Iterable<InteretUtilisateur> findAll();

    void save(String idUser, int idInteret);

    void delete(String id_user, int idInteret);

}
