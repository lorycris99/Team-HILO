package com.hilo.controller;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.healthworkermanagement.repository.HealthWorkerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {
  @Autowired
  HealthWorkerRepository hwr;

  @GetMapping("/health_worker/all")
  List<HealthWorker> getAll() {
    return hwr.findAll();
  }
}
