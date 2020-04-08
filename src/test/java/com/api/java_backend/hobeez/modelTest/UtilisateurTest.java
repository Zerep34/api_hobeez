package com.api.java_backend.hobeez.modelTest;

import com.api.java_backend.hobeez.model.Utilisateurs;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilisateurTest {

    Utilisateurs user;

    Date birthdate;

    @Before
    public void before() throws ParseException {
        this.birthdate = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
        user = new Utilisateurs("test@mail.com", "pass", "test", birthdate, true);
    }

    @Test
    public void test_emptyUser(){
        Utilisateurs user = new Utilisateurs();
        Assertions.assertNull(user.getEmail());
    }

    @Test
    public void testGetFullName(){
        Assertions.assertEquals("test", user.getFull_name());
    }

    @Test
    public void testSetFullName(){
        user.setFull_name("test_user");
        Assertions.assertEquals("test_user", user.getFull_name());
    }


    @Test
    public void testGetEmail(){
        Assertions.assertEquals("test@mail.com", user.getEmail());
    }

    @Test
    public void testSetEmail(){
        user.setEmail("user@mail.com");
        Assertions.assertEquals("user@mail.com", user.getEmail());
    }

    @Test
    public void testGetPassword(){
        Assertions.assertEquals("pass", user.getPass());
    }

    @Test
    public void testSetPassword(){
        user.setPass("mdp");
        Assertions.assertEquals("mdp", user.getPass());
    }

    @Test
    public void testGetBirthDate() throws ParseException {
        Date birthdate_temp = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2999");
        user.setBirthdate(birthdate_temp);
        Assertions.assertEquals(birthdate_temp, user.getBirthdate());
    }

    @Test
    public void testHasChild(){
        Assertions.assertTrue(user.hasChild());
    }

    @Test
    public void testSetHasChild(){
        user.setHasChild(false);
        Assertions.assertFalse(user.hasChild());
    }
}
