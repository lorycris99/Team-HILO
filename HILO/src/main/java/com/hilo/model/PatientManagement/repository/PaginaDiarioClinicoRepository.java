package com.hilo.model.PatientManagement.repository;

import com.hilo.model.PatientManagement.entity.EmbeddedPaginaDiarioClinico;
import com.hilo.model.PatientManagement.entity.PaginaDiarioClinico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginaDiarioClinicoRepository extends JpaRepository<PaginaDiarioClinico, EmbeddedPaginaDiarioClinico> {}
