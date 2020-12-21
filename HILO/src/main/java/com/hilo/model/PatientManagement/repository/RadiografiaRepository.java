package com.hilo.model.PatientManagement.repository;

import com.hilo.model.PatientManagement.entity.EmbeddedRadiografia;
import com.hilo.model.PatientManagement.entity.Radiografia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiografiaRepository extends JpaRepository<Radiografia, EmbeddedRadiografia> {

}
