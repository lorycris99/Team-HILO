package com.hilo.model.swabmanagement.entity;

import com.hilo.model.swabmanagement.repository.EffettuapRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EffettuapManager {
  @Autowired
  private EffettuapRepository epr;

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
    List<EffettuaP> temp = epr.findByTimestampBetween(t1, t2);
    List<Integer> list = new ArrayList<Integer>();
    for (EffettuaP ep : temp) {
      list.add(ep.getIdTampone());
    }
    return list;
  }
}
