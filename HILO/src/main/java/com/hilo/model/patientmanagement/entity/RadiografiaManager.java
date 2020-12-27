package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.RadiografiaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class RadiografiaManager {
  public RadiografiaManager(){

  }

  @Autowired
  RadiografiaRepository rr;

  public void createRadiografia(Radiografia r) {
    rr.save(r);
  }

  public void delteRadiografia(Radiografia r) {
    rr.delete(r);
  }

  public void updateRadiografia(Radiografia r) {
    createRadiografia(r);
  }

  public List<Radiografia> findAll() {
    return rr.findAll();
  }

  public Radiografia findById(String cf, Integer n) {
    EmbeddedRadiografia identifier = new EmbeddedRadiografia();
    identifier.setCfpaziente(cf);
    identifier.setNumero(n);

    Optional<Radiografia> toGet = rr.findById(identifier);

    if (toGet.isPresent()) {
      return toGet.get();
    } else {
      return null;
    }
  }

}
