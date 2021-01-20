package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 PaginaDiarioClinicoTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPaginaDiarioClinico {

  @Test
  @Order(1)
  public void equalsTest() {
    PaginaDiarioClinico a = new PaginaDiarioClinico();
    a.setCfPaziente("abc");
    a.setNote("ok");
    a.setNumero(10);
    a.setSintomi("no");
    a.setTemperatura(41.1);
    a.setTerapia("nulla");
    a.setTimestamp("kkk");

    PaginaDiarioClinico b = new PaginaDiarioClinico();
    b.setCfPaziente("abc");
    b.setNote("ok");
    b.setNumero(10);
    b.setSintomi("no");
    b.setTemperatura(41.1);
    b.setTerapia("nulla");
    b.setTimestamp("kkk");

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));

    b.setCfPaziente("aaa");
    Assertions.assertEquals(false, a.equals(b));
    b.setCfPaziente("abc");
    b.setNote("s");
    Assertions.assertEquals(false, a.equals(b));
    b.setNote("ok");
    b.setNumero(100);
    Assertions.assertEquals(false, a.equals(b));
    b.setNumero(10);
    b.setSintomi("si");
    Assertions.assertEquals(false, a.equals(b));
    b.setSintomi("no");
    b.setTemperatura(25.2);
    Assertions.assertEquals(false, a.equals(b));
    b.setTemperatura(41.1);
    b.setTerapia("si");
    Assertions.assertEquals(false, a.equals(b));
    b.setTerapia("nulla");
    b.setTimestamp("qqq");
    Assertions.assertEquals(false, a.equals(b));
    b.setTimestamp("kkk");
    a.setCfPaziente(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setCfPaziente(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setCfPaziente("abc");
    b.setCfPaziente("abc");
    a.setNote(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setNote(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setNote("ok");
    b.setNote("ok");
    a.setNumero(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setNumero(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setNumero(10);
    b.setNumero(10);
    a.setSintomi(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setSintomi(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setSintomi("no");
    b.setSintomi("no");
    a.setTemperatura(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setTemperatura(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setTemperatura(41.1);
    b.setTemperatura(41.1);
    a.setTerapia(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setTerapia(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setTerapia("nulla");
    b.setTerapia("nulla");
    a.setTimestamp(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setTimestamp(null);
    Assertions.assertEquals(true, a.equals(b));

  }
}
