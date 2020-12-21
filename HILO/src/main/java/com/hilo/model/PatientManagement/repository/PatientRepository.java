package com.hilo.model.PatientManagement.repository;

import com.hilo.model.PatientManagement.entity.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

}
