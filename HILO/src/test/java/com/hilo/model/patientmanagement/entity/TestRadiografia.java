package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 RadiografiaTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRadiografia {

  @Test
  @Order(1)
  public void equalsTest() {
    byte[] bytes = new byte[10];
    Radiografia a = new Radiografia();
    a.setCfpaziente("abc");
    a.setImg(bytes);
    a.setNumero(10);

    Radiografia b = new Radiografia();
    b.setCfpaziente("abc");
    b.setImg(bytes);
    b.setNumero(10);

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));

    b.setCfpaziente("aaa");
    Assertions.assertEquals(false, a.equals(b));
    b.setCfpaziente("abc");
    b.setImg(new byte[100]);
    Assertions.assertEquals(false, a.equals(b));
    b.setImg(bytes);
    b.setNumero(60);
    Assertions.assertEquals(false, a.equals(b));
    b.setNumero(10);
    a.setCfpaziente(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setCfpaziente(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setCfpaziente("abc");
    b.setCfpaziente("abc");
    a.setNumero(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setNumero(null);
    Assertions.assertEquals(true, a.equals(b));
    a.setNumero(10);
    b.setNumero(10);
    a.setImg(null);
    Assertions.assertEquals(false, a.equals(b));
    b.setImg(null);
    Assertions.assertEquals(true, a.equals(b));
  }
}
