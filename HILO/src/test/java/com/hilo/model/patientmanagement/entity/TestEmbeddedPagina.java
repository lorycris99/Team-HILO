package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EmbeddedPaginaTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmbeddedPagina {

    @Test
    @Order(1)
    public void equalsTest(){
        EmbeddedPagina a=new EmbeddedPagina();
        a.setCfPaziente("abc");
        a.setNumero(10);

        EmbeddedPagina b=new EmbeddedPagina();
        b.setCfPaziente("abc");
        b.setNumero(10);

        Assertions.assertEquals(true, a.equals(a));
        Assertions.assertEquals(true, a.equals(b));
        Assertions.assertEquals(false, a.equals(null));
        Assertions.assertEquals(false, a.equals(""));
        b.setNumero(100);
        Assertions.assertEquals(false, a.equals(b));
        b.setNumero(10);
        b.setCfPaziente("aaa");
        Assertions.assertEquals(false, a.equals(b));
        b.setCfPaziente("abc");
        a.setCfPaziente(null);
        Assertions.assertEquals(false, a.equals(b));
        a.setCfPaziente("abc");
        a.setNumero(null);
        Assertions.assertEquals(false, a.equals(b));
        b.setNumero(null);
        Assertions.assertEquals(true, a.equals(b));
        a.setCfPaziente(null);
        b.setCfPaziente(null);
        Assertions.assertEquals(true, a.equals(b));

    }
}
