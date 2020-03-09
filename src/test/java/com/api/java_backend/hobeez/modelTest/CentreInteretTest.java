package com.api.java_backend.hobeez.modelTest;

import com.api.java_backend.hobeez.model.CentreInteret;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CentreInteretTest {

    CentreInteret coup;

    @Before
    public void before() throws ParseException {
        coup = new CentreInteret(20, "football");
    }

    @Test
    public void testCouponsConstructorEmpty() {
        CentreInteret coup = new CentreInteret();
        Assertions.assertEquals(0, coup.getId());
    }

    @Test
    public void testCouponsConstructor() {
        Assertions.assertEquals(20, coup.getId());
        Assertions.assertEquals("football", coup.getLibelle());
    }

    @Test
    public void testSetId() {
        coup.setId(1);
        Assertions.assertEquals(1, coup.getId());
    }

    @Test
    public void testSetLibelle() {
        coup.setLibelle("tennis");
        Assertions.assertEquals("tennis", coup.getLibelle());
    }

    @Test
    public void ToString() {
        Assertions.assertEquals("CentreInteret{id=20, libelle='football'}", coup.toString());
    }
}
