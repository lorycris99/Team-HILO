package com.hilo.model.patientmanagement.repository;

import com.hilo.model.patientmanagement.entity.EmbeddedPagina;
import com.hilo.model.patientmanagement.entity.Pagina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginaRepository extends JpaRepository<Pagina, EmbeddedPagina> {}
