package com.hilo.model.swabmanagement.entity;

import com.hilo.model.swabmanagement.repository.SwabRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Questa classe permette di gestire un insieme di tamponi persistenti con tutte le operazioni
 * fondamentali.
 */
@Component
public class SwabManager {
  @Autowired
  private SwabRepository repo;

  public SwabManager() {

  }

  /**
   * Permette il salvataggio di un tampone in modo persistente.
   *
   * @param tampone il tampone da rendere persistente
   */
  public void createSwab(Swab tampone) {
    repo.save(tampone);
  }

  /**
   * Permette di eliminare un tampone precedentemente reso persistente.
   *
   * @param tampone il tampone da eliminare
   */
  public void deleteSwab(Swab tampone) {
    repo.delete(tampone);
  }

  /**
   * Permette di aggiornare i dati contenuti all'interno dell'archivio persistente.
   *
   * @param tampone il tampone con le modifiche da salvare
   */
  public void updateSwab(Swab tampone) {
    createSwab(tampone);
  }

  /**
   * Permette di ottenere una lista con tutti i tamponi salvati all'interno dell'archivio.
   *
   * @return una lista con tutti i tamponi effettuati
   */
  public List<Swab> findAll() {
    return repo.findAll();
  }

  /**
   * Permette di trovare uno specifico tampone all'interno dell'archivio per mezzo del suo id.
   *
   * @param id id del tampone da ricercare
   *
   * @return il tampone corrispondente a quell'id, null nel caso non dovesse esistere
   */
  public Swab findById(int id) {

    Optional<Swab> temp = repo.findById(id);
    if (temp.isPresent()) {
      return temp.get();
    } else {
      return null;
    }
  }

  /**
   * Permette di trovare tutti i tamponi con un determinato esito associato.
   *
   * @param esito l'esito che si vuole ricercare (Positivo, Negativo, Inconcludente).
   *
   * @return una lista con tutti i tamponi con quell'esito
   */
  public List<Swab> findByEsito(String esito) {
    return repo.findByRisultato(esito);
  }

  /**
   * Permette di trovare tamponi in base alla provenienza dei pazienti che li hanno effettuati,
   * ovvero se i pazienti sono interni oppure no.
   *
   * @param valore true nel caso di tamponi interni, false nel caso di tamponi esterni
   *
   * @return una lista di tamponi interni (o esterni)
   */
  public List<Swab> findByInterno(Boolean valore) {
    return repo.findByIsInterno(valore);
  }

  /**
   * Permette di trovare tamponi in base alla struttura di provenienza.
   *
   * @param id identificativo della struttura
   *
   * @return una lista con tutti i tamponi effettuati in quella struttura
   */
  public List<Swab> findByStruttura(Integer id) {
    return repo.findByIdStruttura(id);
  }


}
