package com.hilo.model.swabmanagement;

import com.hilo.model.swabmanagement.entity.EffettuaP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EffettuaPTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEffettuaP {
  @Test
  @Order(1)
  public void equalsTest() {
    EffettuaP a = new EffettuaP();
    a.setCfP("aa"); 
    a.setGravity(10.5); 
    a.setIdTampone(1); 
    a.setTimestamp("1010");

    EffettuaP b = new EffettuaP();
    b.setCfP("aa"); 
    b.setGravity(10.5); 
    b.setIdTampone(1); 
    b.setTimestamp("1010");

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));
    
    b.setCfP("oo");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setCfP("aa"); 
    b.setIdTampone(22);
    Assertions.assertEquals(false, a.equals(b));
    
    b.setIdTampone(1); 
    b.setTimestamp("ok");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setTimestamp("1010"); 
    b.setGravity(14.5);
    Assertions.assertEquals(false, a.equals(b));
  }
}
