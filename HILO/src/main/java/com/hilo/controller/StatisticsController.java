package com.hilo.controller;


import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.statisticsmanagement.Statistica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


@RestController

public class StatisticsController {

  public Statistica getStatistiche() {
    throw new NotImplementedException();
  }
}
