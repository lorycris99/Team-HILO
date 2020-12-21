package com.hilo.patient.repository;

import com.hilo.patient.entity.EmbeddedRadiografia;
import com.hilo.patient.entity.Radiografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiografiaRepository extends JpaRepository<Radiografia, EmbeddedRadiografia> {

}
