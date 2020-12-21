package com.hilo.controller;

import com.hilo.model.HealthWorkerManagement.entity.HealthWorker;
import com.hilo.model.HealthWorkerManagement.repository.HealthWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {
    @Autowired
    HealthWorkerRepository hwr;

    @GetMapping("/health_worker/all")
    List<HealthWorker> getAll(){
        return hwr.findAll();
    }
}
