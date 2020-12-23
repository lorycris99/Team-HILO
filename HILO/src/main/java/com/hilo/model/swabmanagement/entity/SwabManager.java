package com.hilo.model.swabmanagement.entity;

import com.hilo.model.swabmanagement.repository.SwabRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwabManager {
  @Autowired
  private SwabRepository repo;

  public SwabManager() {

  }

  public void createSwab(Swab tampone) {
    repo.save(tampone);
  }

  public void deleteSwab(Swab tampone) {
    repo.delete(tampone);
  }

  public void updateSwab(Swab tampone) {
    createSwab(tampone);
  }

  public List<Swab> findAll() {
    return repo.findAll();
  }

  public Optional<Swab> findById(int id) {
    return repo.findById(id);
  }

  public List<Swab> findByEsito(String esito) {
    return repo.findByRisultato(esito);
  }

  public List<Swab> findByInterno(Boolean valore) {
    return repo.findByIsInterno(valore);
  }

  public List<Swab> findByStruttura(String id) {
    return repo.findByIdStruttura(id);
  }



}
