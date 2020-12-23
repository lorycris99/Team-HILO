package com.hilo.model.adminmanagement.repository;

import com.hilo.model.adminmanagement.entity.Struttura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrutturaRepository extends JpaRepository<Struttura, Integer> {

}
