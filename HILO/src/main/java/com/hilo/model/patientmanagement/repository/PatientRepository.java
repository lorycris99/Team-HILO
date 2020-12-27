package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.Patient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

   Patient findByUsernameAndPassword(String username, String password);

   List<Patient> findByIsInterno(Boolean v);

   Patient findByTelefono(String tel);

   Patient findByMail(String mail);

   List<Patient> findByCognome(String c);


}
