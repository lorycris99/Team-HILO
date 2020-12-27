package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.EmbeddedPaginaDiarioClinico;
import com.hilo.model.patientmanagement.entity.PaginaDiarioClinico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginaDiarioClinicoRepository extends JpaRepository<PaginaDiarioClinico,
        EmbeddedPaginaDiarioClinico> {
  List<PaginaDiarioClinico> findByCfPaziente(String cf);

}
