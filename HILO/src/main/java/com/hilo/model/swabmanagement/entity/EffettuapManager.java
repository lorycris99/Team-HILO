package com.hilo.model.swabmanagement.entity;

import com.hilo.model.swabmanagement.repository.EffettuapRepository;
import com.hilo.model.swabmanagement.repository.SwabRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EffettuapManager {
  @Autowired
  private EffettuapRepository epr;
  @Autowired
  private SwabRepository swabRepo;

  public void createEffettuaP(EffettuaP ep) {
    epr.save(ep);
  }

  public void removeEffettuaP(EffettuaP ep) {
    epr.delete(ep);
  }

  public void updateEffettuaP(EffettuaP ep) {
    createEffettuaP(ep);
  }

  public EffettuaP findById(EmbeddedEffettuaP eep) {
    Optional<EffettuaP> optional = epr.findById(eep);
    if (optional.isPresent()) {
      return optional.get();
    } else {
      return null;
    }
  }

  public List<EffettuaP> findAll() {
    return epr.findAll();
  }

  public List<Integer> findTimestampBetween(String t1, String t2) {
    if (t1.matches("\\d{4}-\\d{2}-\\d{2}") && t2.matches("\\d{4}-\\d{2}-\\d{2}")) {

      List<EffettuaP> temp = epr.findByTimestampBetween(t1, t2);
      List<Integer> list = new ArrayList<Integer>();
      for (EffettuaP ep : temp) {
        list.add(ep.getIdTampone());
      }
      return list;
    } else {
      throw new IllegalArgumentException("Una delle date non e' nel formato YYYY-MM-DD");
    }
  }

  public List<EffettuaP> findByGravityGreaterThan(double gravity) {
    return epr.findByGravityGreaterThan(gravity);
  }

  public List<EffettuaP> findByTimestamp(String timestamp) {
    if (timestamp.matches("\\d{4}-\\d{2}-\\d{2}")) {
      return epr.findByTimestamp(timestamp);
    } else {
      throw new IllegalArgumentException("La data non e' nel formato YYYY-MM-DD");
    }
  }

  public Swab findByIdTampone(int id) {
    EffettuaP eff = epr.findByIdTampone(id);
    List<Swab> listaTamponi = swabRepo.findAll();

    Swab filter = null;

    for (int i = 0; i < listaTamponi.size(); i++) {
      if (eff.getIdTampone() == listaTamponi.get(i).getId()) {
        return listaTamponi.get(i);
      }
    }

    return null;
  }

  public EffettuaP findEffettuapByIdTampone(int id) {
    return epr.findByIdTampone(id);
  }
}
