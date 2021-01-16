package com.hilo.model.swab;

import com.hilo.model.swabmanagement.entity.Swab;
import com.hilo.model.swabmanagement.entity.SwabManager;
import com.hilo.model.swabmanagement.entity.SwabQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 SwabTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSwab {
  @Autowired
  private SwabManager sm;
  
  @Autowired
  private SwabQueue swq;
    

  @Test
  @Order(1)
  public void testLista() {
    Swab interno = sm.findById(1);
    Swab esternoP = sm.findById(7);
    Swab esternoA = sm.findById(2);
    Swab internoTest = sm.findById(4);
    swq.enqueue(interno);
    swq.enqueue(esternoA);
    swq.enqueue(esternoP);
    swq.enqueue(internoTest);
    Assertions.assertEquals(internoTest, swq.getTop());
    Assertions.assertEquals(interno, swq.getTop());
    Assertions.assertEquals(esternoA, swq.getTop());
    Assertions.assertEquals(esternoP, swq.getTop());
  }

  @Test
  @Order(2)
  public void idTest() {
    Swab s = new Swab();
    s.setId(12);
    Assertions.assertEquals(s.getId(), 12);
  }

  @Test
  @Order(3)
  public void risultatoTest() {
    Swab s = new Swab();
    s.setRisultato("test");
    Assertions.assertEquals(s.getRisultato(), "test");
  }

  @Test
  @Order(4)
  public void internoTest() {
    Swab s = new Swab();
    s.setIsInterno(true);
    Assertions.assertEquals(s.getIsInterno(), true);
  }

  @Test
  @Order(5)
  public void idStrutturaTest() {
    Swab s = new Swab();
    s.setIdStruttura(100);
    Assertions.assertEquals(s.getIdStruttura(), 100);
  }

  @Test
  @Order(6)
  public void equalsTest(){
    Swab a=new Swab();
    Swab b=new Swab();
    a.setId(1); a.setRisultato("");a.setIsInterno(true); a.setIdStruttura(10);
    b.setId(1); b.setRisultato("");b.setIsInterno(true); b.setIdStruttura(10);
    Assertions.assertEquals(true,a.equals(b));
    Assertions.assertEquals(false,a.equals(null));
    Assertions.assertEquals(false,a.equals(""));
    b.setId(2);
    Assertions.assertEquals(false,a.equals(b));
    b.setId(1); b.setIdStruttura(20);
    Assertions.assertEquals(false,a.equals(b));
    b.setIdStruttura(10); b.setIsInterno(false);
    Assertions.assertEquals(false,a.equals(b));
    b.setIsInterno(true); b.setRisultato("ok");
    Assertions.assertEquals(false,a.equals(b));







  }
}