package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EmbeddedRadiografiaTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmbeddedRadiografia {

    @Test
    @Order(1)
    public void equalsTest(){
        EmbeddedRadiografia a=new EmbeddedRadiografia();
        a.setCfpaziente("abc");
        a.setNumero(10);

        EmbeddedRadiografia b=new EmbeddedRadiografia();
        b.setCfpaziente("abc");
        b.setNumero(10);

        Assertions.assertEquals(true, a.equals(a));
        Assertions.assertEquals(true, a.equals(b));
        Assertions.assertEquals(false, a.equals(null));
        Assertions.assertEquals(false, a.equals(""));
        b.setNumero(100);
        Assertions.assertEquals(false, a.equals(b));
        b.setNumero(10);
        b.setCfpaziente("aaa");
        Assertions.assertEquals(false, a.equals(b));

        b.setCfpaziente("abc");
        a.setCfpaziente(null);
        Assertions.assertEquals(false, a.equals(b));
        a.setCfpaziente("abc");
        a.setNumero(null);
        Assertions.assertEquals(false, a.equals(b));
        b.setNumero(null);
        Assertions.assertEquals(true, a.equals(b));
        a.setCfpaziente(null);
        b.setCfpaziente(null);
        Assertions.assertEquals(true, a.equals(b));
    }
}
