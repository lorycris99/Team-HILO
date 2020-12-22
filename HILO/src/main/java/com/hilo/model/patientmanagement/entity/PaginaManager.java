package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.PaginaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaginaManager {
  public PaginaManager() {
  }

  @Autowired
  private PaginaRepository repo;

  public void createPagina(Pagina p) {
    repo.save(p);
  }

  public void deletePagina(Pagina p) {
    repo.delete(p);
  }

  public void updatePagina(Pagina p) {
    createPagina(p);
  }

  public Pagina findById(Integer numero, String cf) {
    EmbeddedPagina primaryKey = new EmbeddedPagina();
    primaryKey.setCfPaziente(cf);
    primaryKey.setNumero(numero);
    Optional<Pagina> toGet = repo.findById(primaryKey);
    if (toGet.isPresent()) {
      return toGet.get();
    } else {
      return null;
    }
  }
  
  public List<Pagina> findAll() {
    return repo.findAll();
  }

  public List<Pagina> findByCf(String cf) {
    return repo.findByCfPaziente(cf);
  }
}
