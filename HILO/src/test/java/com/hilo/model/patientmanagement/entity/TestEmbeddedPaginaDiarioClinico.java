package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EmbeddedPaginaDiarioClinicoTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmbeddedPaginaDiarioClinico {

  @Test
  @Order(1)
  public void equalsTest() {
    EmbeddedPaginaDiarioClinico a = new EmbeddedPaginaDiarioClinico();
    a.setCfPaziente("abc");
    a.setNumero(10);

    EmbeddedPaginaDiarioClinico b = new EmbeddedPaginaDiarioClinico();
    b.setCfPaziente("abc");
    b.setNumero(10);

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));
    b.setNumero(20);
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
