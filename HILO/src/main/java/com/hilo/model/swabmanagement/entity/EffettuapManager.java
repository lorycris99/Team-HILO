package com.hilo.model.swabmanagement.entity;

import com.hilo.controller.ErrorController;
import com.hilo.model.swabmanagement.repository.EffettuapRepository;
import com.hilo.model.swabmanagement.repository.SwabRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Questa classe serve per gestire le relazioni EffettuaP, ovvero quella che modella
 * un paziente che ha effettuato un tampone.
 */
@Component
public class EffettuapManager {
  @Autowired
  private EffettuapRepository epr;
  @Autowired
  private SwabRepository swabRepo;
  @Autowired
  private SwabManager sm;
  @Autowired
  private ErrorController error;

  /**
   * Permette di salvare un EffettuaP in modo persistente.
   *
   * @param ep l'EffettuaP da salvare
   */
  public void createEffettuaP(EffettuaP ep) {
    epr.save(ep);
  }

  /**
   * Permette di eliminare dall'archivio un EffettuaP.
   *
   * @param ep l'EffettuaP da eliminare
   */
  public void removeEffettuaP(EffettuaP ep) {
    epr.delete(ep);
  }

  /**
   * Permette di aggiornare un EffettuaP nell'archivio.
   *
   * @param ep l'EffettuaP da aggiornare
   */
  public void updateEffettuaP(EffettuaP ep) {
    createEffettuaP(ep);
  }

  /**
   * Permette di trovare un EffettuaP grazie al suo ID.
   *
   * @param eep l'ID dell'EffettuaP
   *
   * @return l'EffettuaP con l'ID specificato, null se non esiste
   */
  public EffettuaP findById(EmbeddedEffettuaP eep) {
    Optional<EffettuaP> optional = epr.findById(eep);
    if (optional.isPresent()) {
      return optional.get();
    } else {
      return null;
    }
  }

  /**
   * Permette di ottenere tutti gli EffettuaP presenti nell'archivio.
   *
   * @return la lista contenente tutti gli EffettuaP nell'archivio
   */
  public List<EffettuaP> findAll() {
    return epr.findAll();
  }

  /**
   * Permette di trovare gli ID dei tamponi associati agli EffettuaP che sono stati
   * effettuati in un determinato intervallo di tempo.
   *
   * @param t1 data rappresentante l'inizio dell'intervallo (formato YYYY-MM-DD)
   *
   * @param t2 data rappresentante la fine dell'intervallo (formato YYYY-MM-DD)
   *
   * @return una lista contenente gli ID dei tamponi effettuati nell'intervallo di tempo
   *         specificato
   */
  public List<Integer> findTimestampBetween(String t1, String t2) {
    if (t1.matches("\\d{4}-\\d{2}-\\d{2}") && t2.matches("\\d{4}-\\d{2}-\\d{2}")) {

      List<EffettuaP> temp = epr.findByTimestampBetween(t1, t2);
      List<Integer> list = new ArrayList<Integer>();
      for (EffettuaP ep : temp) {
        list.add(ep.getIdTampone());
      }
      return list;
    } else {
      error.manageError(new IllegalArgumentException(
              "Una delle date non e' nel formato YYYY-MM-DD"));
      return null;
    }
  }

  /**
   * Permette di trovare una lista di EffettuaP associati a tamponi con una probabilita' di
   * positivita' maggiore di una soglia specificata.
   *
   * @param gravity la probabilita' minima da ricercare
   *
   * @return la lista di EffettuaP associati a tamponi con probabilita' piu' alta della soglia
   */
  public List<EffettuaP> findByGravityGreaterThan(double gravity) {
    return epr.findByGravityGreaterThan(gravity);
  }

  /**
   * Permette di trovare una lista di EffettuaP associati a tamponi effettuati in una determinata
   * data.
   *
   * @param timestamp la data da ricercare (formato YYYY-MM-DD)
   *
   * @return la lista di EffettuaP associati a tamponi effettuati nella data specificata
   */
  public List<EffettuaP> findByTimestamp(String timestamp) {
    if (timestamp.matches("\\d{4}-\\d{2}-\\d{2}")) {
      return epr.findByTimestamp(timestamp);
    } else {
      error.manageError(new IllegalArgumentException("La data non e' nel formato YYYY-MM-DD"));
      return null;
    }
  }

  /**
   * Permette di trovare un EffettuaP in base all'ID del tampone associato.
   *
   * @param id l'ID da ricercare
   *
   * @return il tampone associato all'ID specificato
   */
  public Swab findByIdTampone(int id) {
    EffettuaP eff = epr.findByIdTampone(id);
    List<Swab> listaTamponi = swabRepo.findAll();
    Swab x = null;

    Swab filter = null;

    for (int i = 0; i < listaTamponi.size(); i++) {
      if (eff.getIdTampone() == listaTamponi.get(i).getId()) {
        x = listaTamponi.get(i);
      }
    }

    return x;
  }

  /**
   * Permette di trovare un EffettuaP associato ad un tampone con un determinato ID.
   *
   * @param id l'ID da ricercare
   *
   * @return l'EffettuaP associato al tampone con l'ID specificato
   */
  public EffettuaP findEffettuapByIdTampone(int id) {
    return epr.findByIdTampone(id);
  }

  /**
   * Permette di trovare una lista di tamponi effettuati da un determinato paziente.
   *
   * @param cf il codice fiscale del paziente
   *
   * @return la lista di tamponi effettuati dal paziente
   */
  public List<Swab> findByCF(String cf) {
    List<Swab> result = new ArrayList<>();
    List<EffettuaP> list = epr.findByCfP(cf);
    for (EffettuaP t : list) {
      result.add(sm.findById(t.getIdTampone()));
    }
    return result;
  }
}
