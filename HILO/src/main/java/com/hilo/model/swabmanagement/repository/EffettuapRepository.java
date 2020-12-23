package com.hilo.model.swabmanagement.repository;

import com.hilo.model.swabmanagement.entity.EffettuaP;
import com.hilo.model.swabmanagement.entity.EmbeddedEffettuaP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffettuapRepository extends JpaRepository<EffettuaP, EmbeddedEffettuaP> {}
