package com.hilo.model.adminmanagement.entity;

import com.hilo.model.adminmanagement.repository.AfferireRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AfferireManager {
  public AfferireManager() {}

  @Autowired
  private AfferireRepository ar;

  public void createAfferire(Afferire a) {
    ar.save(a);
  }

  public void updateAfferire(Afferire a) {
    createAfferire(a);
  }

  public void deleteAfferire(Afferire a) {
    ar.delete(a);
  }

  public List<Afferire> findAll() {
    return ar.findAll();
  }

  public Afferire findById(EmbeddedAfferire id) {
    Optional<Afferire> optional = ar.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    } else {
      return null;
    }
  } 

  public List<Afferire> findByIdStruttura(Integer id) {
    return ar.findByIdStruttura(id);
  }

  public List<Afferire> findByCfPaziente(String cf) {
    return ar.findByCfPaziente(cf);
  }

  public List<Afferire> findByGiorniGreaterThan(Integer giorni) {
    return ar.findByGiorniGreaterThan(giorni);
  }
}
