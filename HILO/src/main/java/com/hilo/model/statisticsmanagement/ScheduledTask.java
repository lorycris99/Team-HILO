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

  @Scheduled(cron = "0 1 0 * * *")
  public void saveTask() {
    List<Swab> tamponi = sm.retreiveTamponi();
    Map<String, Integer> tamponiMappa = sm.getSommaEsiti(tamponi);
    Statistica s = sm.getStatistiche(tamponiMappa);
    System.out.println("\n\n\nTask Schedulato fatto\n\n\n");
    sm.saveStats(s);
  }
}
