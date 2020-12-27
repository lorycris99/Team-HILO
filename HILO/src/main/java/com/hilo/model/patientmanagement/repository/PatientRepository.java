package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.Patient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

  public Patient findByUsernameAndPassword(String username, String password);

  public List<Patient> findByIsInterno(Boolean v);

  public Patient findByTelefono(String tel);

  public Patient findByMail(String mail);

  public List<Patient> findByCognome(String c);


}
