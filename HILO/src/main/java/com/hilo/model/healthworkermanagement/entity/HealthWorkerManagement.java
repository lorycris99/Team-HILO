package com.hilo.model.healthworkermanagement.entity;

import com.hilo.model.adminmanagement.entity.Struttura;
import com.hilo.model.healthworkermanagement.repository.HealthWorkerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


public class HealthWorkerManagement {
  public HealthWorkerManagement(){

  }

  @Autowired
  HealthWorkerRepository hwr;

  public void createHwr(HealthWorker hw) {
    hwr.save(hw);
  }

  public void deleteHwr(HealthWorker hw) {
    hwr.delete(hw);
  }

  public void updateHwr(HealthWorker hw) {
    createHwr(hw);
  }

  public HealthWorker findById(String cf) {
    Optional<HealthWorker> toGet = hwr.findById(cf);
    if (toGet.isPresent()) {
      return toGet.get();
    } else {
      return null;
    }
  }

  public List<HealthWorker> findAll() {
    return hwr.findAll();
  }
}
