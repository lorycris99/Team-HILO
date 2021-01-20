package com.hilo.model.statisticsmanagement;

import com.hilo.model.swabmanagement.entity.Swab;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@DisplayName("JUnit 5 TestStatisticsManager")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStatisticsManager {

  @Autowired
  private StatisticaManager manager;

  @Test
  @Order(1)
  public void getSommaEsitiTest() {
    List<Swab> lista = new ArrayList<>();
    for(int i = 0; i < 4; i++) {
      lista.add(new Swab());
    }

    lista.get(0).setRisultato("positivo");
    lista.get(1).setRisultato("negativo");
    lista.get(2).setRisultato("inconcludente");
    lista.get(3).setRisultato("");

    Map<String, Integer> map = manager.getSommaEsiti(lista);
    Map<String, Integer> map2 = new HashMap<>();
    map2.put("Positivo", 1);
    map2.put("Negativo", 1);
    map2.put("Inconcludente", 1);
    map2.put("Non analizzato", 1);

    Assertions.assertEquals(map2, map);
  }

}

