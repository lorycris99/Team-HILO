package com.hilo.model.swabmanagement.repository;

import com.hilo.model.swabmanagement.entity.EffettuaP;
import com.hilo.model.swabmanagement.entity.EmbeddedEffettuaP;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffettuapRepository extends JpaRepository<EffettuaP, EmbeddedEffettuaP> {
  List<EffettuaP> findByTimestampBetween(String t1, String t2);
  List<EffettuaP> findByGravityGreaterThan(double gravity);
  List<EffettuaP> findByTimestamp(String timestamp);
  List<EffettuaP> findByIdTampone(int idTampone);
}
