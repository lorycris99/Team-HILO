package com.hilo.model.adminmanagement.repository;

import com.hilo.model.adminmanagement.entity.Struttura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrutturaRepository extends JpaRepository<Struttura, Integer> {

  List<Struttura> findByRegione(String regione);

  Struttura findByNome(String nome);

  List<Struttura> findByIsanalisis(Boolean is);

}
