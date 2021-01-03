package com.hilo.model.statisticsmanagement;

import com.hilo.model.swabmanagement.entity.Swab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledTask {
  @Autowired
  private StatisticaManagement sm;

  @Scheduled(cron = "50 06 17 * * *")
  public void saveTask() {
    List<Swab> tamponi = sm.retreiveTamponi();
    Map<String, Integer> tamponiMappa = sm.getSommaEsiti(tamponi);
    Statistica s = sm.getStatistiche(tamponiMappa);
    System.out.println("\n\n\nTask Schedulato fatto\n\n\n");
    try {
      sm.saveStats(s);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      System.out.println(sm.readStats() + "");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
