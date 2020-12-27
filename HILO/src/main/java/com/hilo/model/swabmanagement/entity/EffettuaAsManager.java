package com.hilo.model.swabmanagement.entity;

import com.hilo.model.swabmanagement.repository.EffettuaAsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EffettuaAsManager {
  @Autowired
  private EffettuaAsRepository ear;

  public void createEffettuaAs(EffettuaAs eas) {
    ear.save(eas);
  }

  public void deleteEffettuaAs(EffettuaAs eas) {
    ear.delete(eas);
  }

  public void updateEffettuaAs(EffettuaAs eas) {
    createEffettuaAs(eas);
  }

  public EffettuaAs findById(EmbeddedEffettuaAs eeas) {
    Optional<EffettuaAs> optional = ear.findById(eeas);
    if (optional.isPresent()) {
      return optional.get();
    } else {
      return null;
    }
  }

  public List<EffettuaAs> findAll() {
    return ear.findAll();
  }

  public List<Integer> findTimestampBetween(String t1, String t2) {
    List<EffettuaAs> temp = ear.findByTimestampBetween(t1, t2);
    List<Integer> list = new ArrayList<Integer>();
    for (EffettuaAs eas : temp) {
      list.add(eas.getIdTampone());
    }
    return list;
  }
}
