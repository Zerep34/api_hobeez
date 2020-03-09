package com.api.java_backend.hobeez.repositoryTest;

import com.api.java_backend.hobeez.model.InteretUtilisateur;
import com.api.java_backend.hobeez.repository.InteretUtilisateurRepository;
import com.api.java_backend.hobeez.repository.implementation.InteretUtilisateurImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InteretUtilisateurTest {

    @Mock
    InteretUtilisateurRepository interetUtilisateurRepository;

    @InjectMocks
    InteretUtilisateurImpl sut;

    @Test
    void testDelete() throws ParseException {
        InteretUtilisateur interetUtilisateur = new InteretUtilisateur("test", 1);
        doNothing().when(interetUtilisateurRepository).delete(interetUtilisateur);
        interetUtilisateurRepository.delete(interetUtilisateur);
        verify(interetUtilisateurRepository, times(1)).delete(interetUtilisateur);
    }

    @Test
    void testFindAll(){
        List<InteretUtilisateur> test_coupon = new ArrayList<InteretUtilisateur>();
        Mockito.doReturn(test_coupon).when(interetUtilisateurRepository).findAll();
        Iterable<InteretUtilisateur> result_list = sut.findAll();
        Assertions.assertEquals(test_coupon, result_list, "No coupons");
    }

    @Test
    void testSavePassant() throws Exception {
        InteretUtilisateur interetUtilisateur = new InteretUtilisateur("test", 1);
        ArgumentCaptor<InteretUtilisateur> ac = ArgumentCaptor.forClass(InteretUtilisateur.class);
        Mockito.doReturn(null).when(interetUtilisateurRepository).save(ac.capture());
        sut.save(interetUtilisateur.getId_user(), interetUtilisateur.getId_interet());
        Assertions.assertEquals(ac.getValue().getId_interet(), interetUtilisateur.getId_interet(), "Saved coupon");
        Assertions.assertEquals(ac.getValue().getId_user(), interetUtilisateur.getId_user(), "Saved coupon");
    }
}
