package com.hilo.model.swabmanagement.repository;

import com.hilo.model.swabmanagement.entity.EffettuaAs;
import com.hilo.model.swabmanagement.entity.EmbeddedEffettuaAs;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffettuaAsRepository extends JpaRepository<EffettuaAs, EmbeddedEffettuaAs> {
  List<EffettuaAs> findByTimestampBetween(String t1, String t2);

  List<EffettuaAs> findByCfAs(String cf);

  EffettuaAs findByIdTampone(int id);
}
