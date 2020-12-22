package com.hilo.controller;


import com.hilo.model.statisticsmanagement.Links;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/statistics/")
public class StatisticsController {
  @GetMapping(path = Links.GET_STATISTICS)
  public ResponseEntity<?> listUsers() {
    return (ResponseEntity<?>) ResponseEntity.ok();
  }
}
