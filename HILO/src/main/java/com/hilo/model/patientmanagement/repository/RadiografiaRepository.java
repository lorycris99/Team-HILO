package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.EmbeddedRadiografia;
import com.hilo.model.patientmanagement.entity.Radiografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiografiaRepository extends JpaRepository<Radiografia, EmbeddedRadiografia> {

}
