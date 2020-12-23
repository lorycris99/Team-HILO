package com.hilo.model.swabmanagement.repository;

import com.hilo.model.swabmanagement.entity.EffettuaAs;
import com.hilo.model.swabmanagement.entity.EmbeddedEffettuaAs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffettuaAsRepository extends JpaRepository<EffettuaAs, EmbeddedEffettuaAs> {}
