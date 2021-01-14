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

  public void createPatient(Patient p) {
    if (findById(p.getCf()) != null) {
      throw new IllegalStateException("CF gia' presente");
    }
    repo.save(p);
  }

  public void deletePatient(Patient p) {
    repo.delete(p);
  }

  public void updatePatient(Patient p) {
    createPatient(p);
  }

  public List<Patient> findAll() {
    return repo.findAll();
  }

  public Patient findById(String id) {
    Optional<Patient> temp = repo.findById(id);
    if (temp.isPresent()) {
      return temp.get();
    } else {
      return null;
    }
  }

  public Patient findByUsernameAndPassword(String user, String pass) {
    return repo.findByUsernameAndPassword(user, pass);
  }

  public List<Patient> findByIsInterno(Boolean val) {
    return repo.findByIsInterno(val);
  }

  public Patient findByTelefono(String tel) {
    return repo.findByTelefono(tel);
  }

  public Patient findByMail(String mail) {
    return repo.findByMail(mail);
  }

  public List<Patient> findByCognome(String cognome) {
    return repo.findByCognome(cognome);
  }



}