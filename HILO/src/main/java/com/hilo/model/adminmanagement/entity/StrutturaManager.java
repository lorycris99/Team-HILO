package com.hilo.model.adminmanagement.entity;

import com.hilo.model.adminmanagement.repository.StrutturaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StrutturaManager {
  public StrutturaManager(){

  }

  @Autowired
  StrutturaRepository sr;

  public void createStruttura(Struttura s) {
    sr.save(s);
  }

  public void deleteStruttura(Struttura s) {
    sr.delete(s);
  }

  public void updateStruttura(Struttura s) {
    createStruttura(s);
  }

  public Struttura findById(Integer id) {
    Optional<Struttura> toGet = sr.findById(id);
    if (toGet.isPresent()) {
      return toGet.get();
    } else {
      return null;
    }
  }

  public List<Struttura> findAll() {
    return sr.findAll();
  }

  public List<Struttura> findByRegione(String reg) {
    return sr.findByRegione(reg);
  }

  public Struttura findByNome(String nome) {
    return sr.findByNome(nome);
  }

  public List<Struttura> findByIsAnalisis(Boolean val) {
    return  sr.findByIsanalisis(val);
  }

}
