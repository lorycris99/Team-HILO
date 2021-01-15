package com.hilo.controller;

import com.hilo.model.statisticsmanagement.Statistica;
import com.hilo.model.statisticsmanagement.StatisticaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsController {

  @Autowired
  private StatisticaManager sm;

  public Statistica getStatistiche() {

    return sm.readStats();
  }
}
