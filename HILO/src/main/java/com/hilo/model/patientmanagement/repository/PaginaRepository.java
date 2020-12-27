package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.EmbeddedPagina;
import com.hilo.model.patientmanagement.entity.Pagina;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginaRepository extends JpaRepository<Pagina, EmbeddedPagina> {
  List<Pagina> findByCfPaziente(String cfPaziente);
}
