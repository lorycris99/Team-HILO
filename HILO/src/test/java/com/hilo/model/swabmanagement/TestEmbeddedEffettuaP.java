package com.hilo.model.swabmanagement;

import com.hilo.model.swabmanagement.entity.EmbeddedEffettuaP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EmbeddedEffettuaPTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmbeddedEffettuaP {

  @Test
  @Order(1)
  public void equalsTest(){
    EmbeddedEffettuaP a=new EmbeddedEffettuaP();
    a.setCfP("abc");
    a.setIdTampone(20);

    EmbeddedEffettuaP b=new EmbeddedEffettuaP();
    b.setCfP("abc");
    b.setIdTampone(20);

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));

    b.setIdTampone(100);
    Assertions.assertEquals(false, a.equals(b));

    b.setIdTampone(20);
    b.setCfP("aaa");
    Assertions.assertEquals(false, a.equals(b));

    b.setCfP("abc");
    a.setCfP(null);
    Assertions.assertEquals(false, a.equals(b));

    a.setCfP("abc");
    a.setIdTampone(null);
    Assertions.assertEquals(false, a.equals(b));

  }

  @Test
  @Order(2)
  public void toStringTest(){
    EmbeddedEffettuaP a=new EmbeddedEffettuaP();
    a.setCfP("abc");
    a.setIdTampone(20);

    Assertions.assertEquals("EmbeddedEffettuaP [cfP=" + "abc" + ", idTampone=" + 20 + "]",a.toString());

  }

}
