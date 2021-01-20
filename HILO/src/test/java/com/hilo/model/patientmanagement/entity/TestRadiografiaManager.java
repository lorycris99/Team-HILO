package com.hilo.model.patientmanagement.entity;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 RadiografiaManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRadiografiaManager {

  @Autowired
  RadiografiaManager manager;

  @Test
  @Order(1)
  public void findIdTest() {
    List<Radiografia> all = manager.findAll();
    Radiografia temp = null;
    for (int i = 0; i < all.size(); i++) {
      if ((all.get(i).getCfpaziente().equals("FRTGRD99A01F912U")) 
            && (all.get(i).getNumero() == 1)) {
        temp = all.get(i);
      }
    }
    Assertions.assertEquals(manager.findById("FRTGRD99A01F912U", 1), temp);
    Assertions.assertNull(manager.findById("abc", 10));
  }

  @Test
  @Order(2)
  public void findCfTest() {
    List<Radiografia> temp = new ArrayList<Radiografia>();
    List<Radiografia> all = manager.findAll();
    for (int i = 0; i < all.size(); i++) {
      if (all.get(i).getCfpaziente().equals("FRTGRD99A01F912U")) {
        temp.add(all.get(i));
      }
    }
    Assertions.assertEquals(manager.findByCfPaziente("FRTGRD99A01F912U"), temp);

  }
}
