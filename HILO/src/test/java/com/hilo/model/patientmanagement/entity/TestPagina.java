package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 PaginaTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPagina {
    private Pagina pagina=null;

    @Test
    @Order(1)
    public void cfTest(){
        pagina=new Pagina();
        pagina.setCfPaziente("123");
        Assertions.assertEquals(pagina.getCfPaziente(), "123");
    }
    @Test
    @Order(2)
    public void numeroTest(){
        pagina=new Pagina();
        pagina.setNumero(10);
        Assertions.assertEquals(pagina.getNumero(), 10);
    }

    @Test
    @Order(3)
    public void noteTest(){
        pagina=new Pagina();
        pagina.setNote("test");
        Assertions.assertEquals(pagina.getNote(), "test");
    }

    @Test
    @Order(4)
    public void sintomiTest(){
        pagina=new Pagina();
        pagina.setSintomi("s");
        Assertions.assertEquals(pagina.getSintomi(), "s");
    }

    @Test
    @Order(5)
    public void temperaturaTest(){
        pagina=new Pagina();
        pagina.setTemperatura(10.5);
        Assertions.assertEquals(pagina.getTemperatura(), 10.5);
    }

    @Test
    @Order(6)
    public void equalsTest(){
        Pagina a=new Pagina();
        Pagina b=new Pagina();
        a.setTemperatura(10.5); a.setSintomi("no"); a.setNote("note"); a.setNumero(20); a.setCfPaziente("1234");
        b.setTemperatura(10.5); b.setSintomi("no"); b.setNote("note"); b.setNumero(20); b.setCfPaziente("1234");
        Assertions.assertEquals(true,a.equals(a));
        Assertions.assertEquals(true,a.equals(b));
        Assertions.assertEquals(false,a.equals(null));
        Assertions.assertEquals(false,a.equals(""));
        b.setTemperatura(11.6);
        Assertions.assertEquals(false,a.equals(b));
        b.setTemperatura(10.5); b.setSintomi("si");
        Assertions.assertEquals(false,a.equals(b));
        b.setSintomi("no"); b.setNote("n");
        Assertions.assertEquals(false,a.equals(b));
        b.setNote("note"); b.setNumero(10);
        Assertions.assertEquals(false,a.equals(b));
        b.setNumero(20); b.setCfPaziente("6666");
        Assertions.assertEquals(false,a.equals(b));
        b.setCfPaziente("1234"); a.setCfPaziente(null);
        Assertions.assertEquals(false,a.equals(b));
        b.setCfPaziente(null);
        Assertions.assertEquals(true,a.equals(b));
        b.setCfPaziente("1234"); a.setCfPaziente("1234");
        b.setNote("note");
        Assertions.assertEquals(true,a.equals(b));
        a.setNote(null);
        Assertions.assertEquals(false,a.equals(b));
        b.setNote(null);
        Assertions.assertEquals(true,a.equals(b));
        a.setNote("note"); b.setNote("note");
        a.setNumero(null);
        Assertions.assertEquals(false,a.equals(b));
        b.setNumero(null);
        Assertions.assertEquals(true,a.equals(b));
        a.setNumero(20); b.setNumero(20);
        a.setSintomi(null);
        Assertions.assertEquals(false,a.equals(b));
        b.setSintomi(null);
        Assertions.assertEquals(true,a.equals(b));
        a.setSintomi("no"); b.setSintomi("no");
        a.setTemperatura(null);
        Assertions.assertEquals(false,a.equals(b));
        b.setTemperatura(null);
        Assertions.assertEquals(true,a.equals(b));











    }



}
