package com.hilo.model.adminmanagement;

import com.hilo.model.adminmanagement.entity.Afferire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 AfferireTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAfferire {

  @Test
  @Order(1)
  public void equalsTest() {
    Afferire a = new Afferire();
    a.setCfpaziente("aaa"); 
    a.setGiorni(2); 
    a.setIdstruttura(9);

    Afferire b = new Afferire();
    b.setCfpaziente("aaa"); 
    b.setGiorni(2); 
    b.setIdstruttura(9);

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));
    b.setIdstruttura(98);
    Assertions.assertEquals(false, a.equals(b));
    
    b.setIdstruttura(9); 
    b.setGiorni(55);
    Assertions.assertEquals(false, a.equals(b));
    
    b.setGiorni(2); 
    b.setCfpaziente("bvc");
    Assertions.assertEquals(false, a.equals(b));
  }
}
