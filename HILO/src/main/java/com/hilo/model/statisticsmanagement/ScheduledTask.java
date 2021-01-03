package com.hilo.model.statisticsmanagement;

import com.hilo.model.swabmanagement.entity.Swab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;
import java.util.Map;

public class ScheduledTask {
  @Autowired
  StatisticaManagement sm;

  @Scheduled(fixedRate = 5000)
  public void saveTask() {
    List<Swab> tamponi = sm.retreiveTamponi();
    Map<String, Integer> tamponiMappa = sm.getSommaEsiti(tamponi);
    Statistica s = sm.getStatistiche(tamponiMappa);
    System.out.println("\n\n\nTask Schedulato fatto\n\n\n");
    sm.saveStats(s);
  }
}
