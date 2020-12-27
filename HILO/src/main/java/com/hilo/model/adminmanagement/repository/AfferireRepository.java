package com.hilo.model.adminmanagement.repository;

import com.hilo.model.adminmanagement.entity.Afferire;
import com.hilo.model.adminmanagement.entity.EmbeddedAfferire;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfferireRepository extends JpaRepository<Afferire, EmbeddedAfferire> {
  public List<Afferire> findByIdStruttura(Integer id);

  public List<Afferire> findByCfPaziente(String cf);
}
