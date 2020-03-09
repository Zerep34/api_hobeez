package com.api.java_backend.hobeez.modelTest;

import com.api.java_backend.hobeez.model.multiKey;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MultiKeyTest {

    multiKey mu;

    @Before
    public void before(){
        mu = new multiKey("test@mail.com", 1);
    }

    @Test
    public void testConstructorEmpty(){
        multiKey mu = new multiKey();
        Assertions.assertNull(mu.getId_user());
    }

    @Test
    public void testContructor(){
        Assertions.assertEquals(1, mu.getId_interet());
    }

    @Test
    public void testGetIdUser(){
        Assertions.assertEquals("test@mail.com", mu.getId_user());
    }

    @Test
    public void testSetIdUser(){
        mu.setId_user("new");
        Assertions.assertEquals("new", mu.getId_user());
    }

    @Test
    public void testGetIdCoupon(){
        Assertions.assertEquals(1, mu.getId_interet());
    }

    @Test
    public void testSetIdCoupon(){
        mu.setId_interet(999);
        Assertions.assertEquals(999, mu.getId_interet());
    }
}
