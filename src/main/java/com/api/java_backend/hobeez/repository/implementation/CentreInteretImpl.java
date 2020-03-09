package com.api.java_backend.hobeez.repository.implementation;

import com.api.java_backend.hobeez.model.CentreInteret;
import com.api.java_backend.hobeez.repository.CentreInteretRepository;
import com.api.java_backend.hobeez.repository.service.CentreInteretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CentreInteretImpl implements CentreInteretService {
    
    private CentreInteretRepository centreInteretRepository;

    @Autowired
    public CentreInteretImpl(CentreInteretRepository centreInteretRepository) {
        this.centreInteretRepository = centreInteretRepository;
    }

    @Override
    public Iterable<CentreInteret> getCentreInteretByUser(String idUser) {
        return this.centreInteretRepository.getCentreInteretByUser(idUser);
    }

    @Transactional
    public void update(int id, String libelle, int oldId){
        this.centreInteretRepository.update(id, libelle, oldId);
    }
}
