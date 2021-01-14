package com.hilo.model.healthworkermanagement.entity;

import com.hilo.model.adminmanagement.entity.Struttura;
import com.hilo.model.healthworkermanagement.repository.HealthWorkerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthWorkerManager {
  public HealthWorkerManager(){

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

  public HealthWorker findByUsername(String username) {
    return hwr.findByUsername(username);
  }

  public List<HealthWorker> findByCognome(String cognome) {
    return hwr.findByCognome(cognome);
  }

  public List<HealthWorker> findByIdStruttura(Integer id) {
    return hwr.findByIdstruttura(id);
  }

  public List<HealthWorker> findByRuolo(String ruolo) {
    return hwr.findByRuolo(ruolo);
  }

  public HealthWorker findByMail(String ruolo) {
    return hwr.findByMail(ruolo);
  }

  public List<HealthWorker> findByTelefono(String telefono) {
    return hwr.findByTelefono(telefono);
  }

  public HealthWorker findByUsernameAndPassword(String username, String password) {
    return hwr.findByUsernameAndPassword(username, password);
  }

}
