package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.EmbeddedRadiografia;
import com.hilo.model.patientmanagement.entity.Radiografia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RadiografiaRepository extends JpaRepository<Radiografia, EmbeddedRadiografia> {

  public List<Radiografia> findByCfpaziente(String cf);

}
