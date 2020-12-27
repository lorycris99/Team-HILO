package com.hilo.model.adminmanagement.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Embedded;

import com.hilo.model.adminmanagement.repository.AfferireRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AfferireManager {
  public AfferireManager() {}

  @Autowired
  private AfferireRepository ar;

  public void creaAfferire(Afferire a) {
    ar.save(a);
  }

  public void updateAfferire(Afferire a) {
    creaAfferire(a);
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
}
