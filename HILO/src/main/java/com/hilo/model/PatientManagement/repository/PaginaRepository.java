package com.hilo.model.PatientManagement.repository;

import com.hilo.model.PatientManagement.entity.EmbeddedPagina;
import com.hilo.model.PatientManagement.entity.Pagina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginaRepository extends JpaRepository<Pagina, EmbeddedPagina> {}
