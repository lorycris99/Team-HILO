package com.hilo.model.swabmanagement.repository;

import com.hilo.model.swabmanagement.entity.Swab;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwabRepository extends JpaRepository<Swab, Integer> {
  List<Swab> findByRisultato(String risultato);

  List<Swab> findByIsInterno(Boolean valore);

  List<Swab> findByIdStruttura(String id);

}
