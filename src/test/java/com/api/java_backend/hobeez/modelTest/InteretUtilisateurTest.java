package com.api.java_backend.hobeez.modelTest;

import com.api.java_backend.hobeez.model.InteretUtilisateur;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InteretUtilisateurTest {
    InteretUtilisateur cbu;

    @Before
    public void before(){
        cbu = new InteretUtilisateur("test", 1);
    }

    @Test
    public void test_emptyInteretUtilisateur(){
        InteretUtilisateur cbu = new InteretUtilisateur();
        Assertions.assertEquals(0, cbu.getId_interet());
    }

    @Test
    public void testGetIdUser(){
        Assertions.assertEquals("test", cbu.getId_user());
    }

    @Test
    public void testSetIdUser(){
        cbu.setId_user("test_user");
        Assertions.assertEquals("test_user", cbu.getId_user());
    }

    @Test
    public void testGetIdCoupon(){
        Assertions.assertEquals(1, cbu.getId_interet());
    }

    @Test
    public void testSetIdCoupon(){
        cbu.setId_interet(2);
        Assertions.assertEquals(2, cbu.getId_interet());
    }

    @Test
    public void testToString(){
        Assertions.assertEquals("InteretUtilisateur{id_user='test', id_interet=1}", cbu.toString());
    }
}
