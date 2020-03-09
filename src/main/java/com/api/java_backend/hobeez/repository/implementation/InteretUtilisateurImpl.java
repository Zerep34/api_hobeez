package com.api.java_backend.hobeez.repository.implementation;

import com.api.java_backend.hobeez.model.InteretUtilisateur;
import com.api.java_backend.hobeez.repository.InteretUtilisateurRepository;
import com.api.java_backend.hobeez.repository.service.InteretUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InteretUtilisateurImpl implements InteretUtilisateurService {

    private InteretUtilisateurRepository interetUtilisateurRepository;

    @Autowired
    public InteretUtilisateurImpl(InteretUtilisateurRepository interetUtilisateurRepository) {
        this.interetUtilisateurRepository = interetUtilisateurRepository;
    }

    @Override
    @Transactional
    public void delete(String id_user, int id_coupon) {
        interetUtilisateurRepository.delete(id_user, id_coupon);
    }

    @Override
    public Iterable<InteretUtilisateur> findAll() {
        return interetUtilisateurRepository.findAll();
    }

    public void save(String idUser, int idCoupon) {
        InteretUtilisateur cp = new InteretUtilisateur(idUser, idCoupon);
        interetUtilisateurRepository.save(cp);
    }

}
