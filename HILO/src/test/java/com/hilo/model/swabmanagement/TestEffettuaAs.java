package com.hilo.model.swabmanagement;

import com.hilo.model.swabmanagement.entity.EffettuaAs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 EffettuaAsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEffettuaAs {
  @Test
  @Order(1)
  public void equalsTest() {
    
    EffettuaAs f = new EffettuaAs();
    f.setTimestamp("ok");
    f.setCfAs("test");
    f.setIdTampone(10);

    EffettuaAs effettuaAs = new EffettuaAs();
    effettuaAs.setCfAs("test");
    effettuaAs.setIdTampone(10);
    effettuaAs.setTimestamp("ok");
        
    Assertions.assertEquals(true, effettuaAs.equals(effettuaAs));
    Assertions.assertEquals(false, effettuaAs.equals(null));
    Assertions.assertEquals(false, effettuaAs.equals(""));
    Assertions.assertEquals(true, effettuaAs.equals(f));
    
    effettuaAs.setIdTampone(5);
    Assertions.assertEquals(false, effettuaAs.equals(f));
    
    effettuaAs.setIdTampone(10); 
    effettuaAs.setCfAs("test2");
    Assertions.assertEquals(false, effettuaAs.equals(f));
    
    effettuaAs.setCfAs("test"); 
    effettuaAs.setTimestamp("lol");
    Assertions.assertEquals(false, effettuaAs.equals(f));
  }
}
