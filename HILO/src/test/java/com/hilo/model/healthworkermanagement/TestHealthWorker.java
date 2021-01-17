package com.hilo.model.healthworkermanagement;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 HealthWorkerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestHealthWorker {

  @Test
  @Order(1)
  public void equalsTest() {
    HealthWorker a = new HealthWorker();
    a.setCf("test"); 
    a.setCognome("c"); 
    a.setIdstruttura(10); 
    a.setIndirizzo("ind"); 
    a.setMail("em");
    a.setNome("n"); 
    a.setPassword("pass"); 
    a.setRuolo("r"); 
    a.setTelefono("333"); 
    a.setUsername("us");

    HealthWorker b = new HealthWorker();
    b.setCf("test");
    b.setCognome("c"); 
    b.setIdstruttura(10); 
    b.setIndirizzo("ind"); 
    b.setMail("em");
    b.setNome("n"); 
    b.setPassword("pass"); 
    b.setRuolo("r"); 
    b.setTelefono("333"); 
    b.setUsername("us");

    Assertions.assertEquals(true, a.equals(a));
    Assertions.assertEquals(true, a.equals(b));
    Assertions.assertEquals(false, a.equals(null));
    Assertions.assertEquals(false, a.equals(""));
    
    b.setCf("cf");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setCf("test"); 
    b.setUsername("y");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setUsername("us"); 
    b.setTelefono("999");
    Assertions.assertEquals(false, a.equals(b));
            
    b.setTelefono("333"); 
    b.setRuolo("vv");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setRuolo("r"); 
    b.setPassword("x");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setPassword("pass"); 
    b.setNome("o");
    Assertions.assertEquals(false, a.equals(b));
    
    b.setNome("n");  
    b.setMail("ll");
    Assertions.assertEquals(false, a.equals(b));
            
    b.setMail("em"); 
    b.setIndirizzo("ok");
    Assertions.assertEquals(false, a.equals(b));
            
    b.setIndirizzo("ind"); 
    b.setIdstruttura(777);
    Assertions.assertEquals(false, a.equals(b));
            
    b.setIdstruttura(10); 
    b.setCognome("bvc");
    Assertions.assertEquals(false, a.equals(b));
  }
}
