package com.hilo.model.adminmanagement;

import com.hilo.model.adminmanagement.entity.Struttura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 StrutturaTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStruttura {

  @Test
  @Order(1)
  public void equalsTest() {
    Struttura a = new Struttura();
    a.setId(1);
    a.setRegione("n");
    a.setNome("p");
    a.setIndirizzo("ind");
    a.setIsanalisis(true);

    Struttura b = new Struttura();
    b.setId(1);
    b.setRegione("n");
    b.setNome("p");
    b.setIndirizzo("ind");
    b.setIsanalisis(true);

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));
    
    b.setId(2);
    Assertions.assertEquals(false, a.equals(b));
    
    b.setId(1); 
    b.setIsanalisis(false);
    Assertions.assertEquals(false, a.equals(b));
    
    b.setIsanalisis(true); 
    b.setIndirizzo("kjh");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setIndirizzo("ind"); 
    b.setNome("mmm");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setNome("p"); 
    b.setRegione("bbb");
    Assertions.assertEquals(false, a.equals(b));
  }
}

