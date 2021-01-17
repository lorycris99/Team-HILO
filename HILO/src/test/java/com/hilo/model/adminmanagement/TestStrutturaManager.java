package com.hilo.model.adminmanagement;

import com.hilo.model.adminmanagement.entity.Struttura;
import com.hilo.model.adminmanagement.entity.StrutturaManager;
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
@DisplayName("JUnit 5 StrutturaManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStrutturaManager {
  @Autowired
  private StrutturaManager manager;

  @Test
  @Order(1)
  public void findIdTest() {
    Struttura temp = null;
    List<Struttura> all = manager.findAll();
    for (int i = 0; i < all.size(); i++) {
      if (all.get(i).getId() == 1) {
        temp = all.get(i);
      }
    }

    Assertions.assertEquals(manager.findById(1), temp);
    Assertions.assertNull(manager.findById(22));
  }
}
