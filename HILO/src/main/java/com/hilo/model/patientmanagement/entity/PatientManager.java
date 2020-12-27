package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.PatientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PatientManager {
  public PatientManager() {
  }

  @Autowired
  private PatientRepository repo;

  public void creaPaziente(Patient p) {
    repo.save(p);
  }

  public void deletePaziente(Patient p) {
    repo.delete(p);
  }

  public void updatePaziente(Patient p) {
    creaPaziente(p);
  }

  public List<Patient> findAll() {
    return repo.findAll();
  }

  public Optional<Patient> findById(String id) {
    return repo.findById(id);
  }



}