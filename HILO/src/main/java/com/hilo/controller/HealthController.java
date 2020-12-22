package com.hilo.controller;

<<<<<<< Updated upstream

import com.hilo.model.HealthWorkerManagement.entity.HealthWorker;
import com.hilo.model.HealthWorkerManagement.repository.HealthWorkerRepository;
import java.util.List;
=======
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.healthworkermanagement.repository.HealthWorkerRepository;

@RestController
public class HealthController {
  @Autowired
  HealthWorkerRepository hwr;

  @GetMapping("/health_worker/all")
  List<HealthWorker> getAll() {
    return hwr.findAll();
  }
}
