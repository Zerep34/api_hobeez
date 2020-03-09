package com.api.java_backend.hobeez.repository.service;

import com.api.java_backend.hobeez.model.CentreInteret;
import org.springframework.stereotype.Service;

@Service
public interface CentreInteretService {

    Iterable<CentreInteret> getCentreInteretByUser(String idUser);

    void update(int id, String libelle, int oldId);
}
