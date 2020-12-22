package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.PaginaDiarioClinicoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaginaDiarioClinicoManager {

  public PaginaDiarioClinicoManager(){

  }

  public void createPaginaDiarioClinico(PaginaDiarioClinico page) {
    repo.save(page);
  }

  public void deletePaginaDiarioClinico(PaginaDiarioClinico page) {
    repo.delete(page);
  }

  public void updatePaginaDiarioClinico(PaginaDiarioClinico page) {
    createPaginaDiarioClinico(page);
  }

  public List<PaginaDiarioClinico> findAll() {
    return repo.findAll();
  }

  public PaginaDiarioClinico findById(int id, String cf) {
    EmbeddedPaginaDiarioClinico identifier = new EmbeddedPaginaDiarioClinico();
    identifier.setNumero(id);
    identifier.setCfPaziente(cf);

    Optional<PaginaDiarioClinico> result = repo.findById(identifier);

    if (result.isPresent()) {
      return result.get();
    } else {
      return null;
    }
  }

  public List<PaginaDiarioClinico> findByCf(String cf) {
    return repo.findByCfPaziente(cf);
  }

  @Autowired
  private PaginaDiarioClinicoRepository repo;
}
