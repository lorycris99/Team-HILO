package com.hilo.model.swabmanagement.entity;

import com.hilo.model.swabmanagement.repository.EffettuaAsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hilo.model.swabmanagement.repository.SwabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EffettuaAsManager {
  @Autowired
  private EffettuaAsRepository ear;
  @Autowired
  private SwabRepository sr;

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

  public List<EffettuaAs> findByCfAs(String cf) {
    return ear.findByCfAs(cf);
  }

  public Swab findByIdTampone(int id) {
    List<EffettuaAs> temp = ear.findByIdTampone(id);
    List<Swab> all = sr.findAll();

    Swab filter = null;

    for (EffettuaAs as: temp) {

      for (int i = 0; i < temp.size(); i++) {
        if (as.getIdTampone() == temp.get(i).getIdTampone()) {
          Optional<Swab> swab = sr.findById(temp.get(i).getIdTampone());
          return swab.get();
        }//if
      }//for i
    }//for as
    return null;
  }
}
