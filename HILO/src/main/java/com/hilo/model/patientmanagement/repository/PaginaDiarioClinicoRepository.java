package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.EmbeddedPaginaDiarioClinico;
import com.hilo.model.patientmanagement.entity.PaginaDiarioClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaginaDiarioClinicoRepository extends JpaRepository<PaginaDiarioClinico,
        EmbeddedPaginaDiarioClinico> {
  List<PaginaDiarioClinico> findByCfPaziente(String cf);

}
