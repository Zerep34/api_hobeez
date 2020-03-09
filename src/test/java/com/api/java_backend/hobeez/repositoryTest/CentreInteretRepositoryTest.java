package com.api.java_backend.hobeez.repositoryTest;

import com.api.java_backend.hobeez.model.CentreInteret;
import com.api.java_backend.hobeez.repository.CentreInteretRepository;
import com.api.java_backend.hobeez.repository.implementation.CentreInteretImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CentreInteretRepositoryTest {

    @Mock
    CentreInteretRepository centreInteretRepository;

    @InjectMocks
    CentreInteretImpl sut;

    @Test
    void testGetCouponByUser(){
        List<CentreInteret> l_coupon = new ArrayList<CentreInteret>();
        Mockito.doReturn(l_coupon).when(centreInteretRepository).getCentreInteretByUser("test");
        Iterable<CentreInteret> result = sut.getCentreInteretByUser("test");
        Assertions.assertEquals(l_coupon, result);
    }

    @Test
    void testUpdatePassant() throws Exception {
        CentreInteret coup = new CentreInteret(20, "centre_interet_test");
        doNothing().when(centreInteretRepository).update(coup.getId(), coup.getLibelle(), coup.getId());
        sut.update(coup.getId(), coup.getLibelle(), coup.getId());
        verify(centreInteretRepository, times(1)).update(coup.getId(), coup.getLibelle(), coup.getId());
    }

    @Test
    void testFindAll(){
        List<CentreInteret> test_coupon = new ArrayList<CentreInteret>();
        Mockito.doReturn(test_coupon).when(centreInteretRepository).findAll();
        Iterable<CentreInteret> result_list = centreInteretRepository.findAll();
        Assertions.assertEquals(test_coupon, result_list, "No coupons");
    }

    @Test
    void testSavePassant() throws Exception {
        CentreInteret coup = new CentreInteret(20, "centre_interet_test");
        ArgumentCaptor<CentreInteret> ac = ArgumentCaptor.forClass(CentreInteret.class);
        Mockito.doReturn(null).when(centreInteretRepository).save(ac.capture());
        centreInteretRepository.save(coup);
        Assertions.assertEquals(ac.getValue().getId(), coup.getId(), "Saved coupon");
    }

    @Test
    void testDelete(){
        CentreInteret coup = new CentreInteret(20, "centre_interet_test");
        doNothing().when(centreInteretRepository).delete(coup);
        centreInteretRepository.delete(coup);
        verify(centreInteretRepository, times(1)).delete(coup);
    }

    @Test
    void TestFindById() {
        CentreInteret coup = new CentreInteret(20, "centre_interet_test");
        Mockito.doReturn(Optional.of(coup)).when(centreInteretRepository).findById(coup.getId());
        Optional<CentreInteret> temp_coup = centreInteretRepository.findById(coup.getId());
        Assertions.assertEquals(coup,temp_coup.get());
    }

}
