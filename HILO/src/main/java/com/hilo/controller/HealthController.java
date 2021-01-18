package com.hilo.controller;

import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.healthworkermanagement.entity.HealthWorkerManager;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.PatientManager;
import com.hilo.model.patientmanagement.entity.RadiografiaManager;
import com.hilo.model.swabmanagement.email.InterceptorMail;
import com.hilo.model.swabmanagement.entity.EffettuaAs;
import com.hilo.model.swabmanagement.entity.EffettuaAsManager;
import com.hilo.model.swabmanagement.entity.EffettuaP;
import com.hilo.model.swabmanagement.entity.EffettuapManager;
import com.hilo.model.swabmanagement.entity.Ryan;
import com.hilo.model.swabmanagement.entity.Swab;
import com.hilo.model.swabmanagement.entity.SwabManager;
import java.util.List;
import java.util.Random;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthController {
  @Autowired
  private HealthWorkerManager hwm;

  @Autowired
  private SwabManager sm;

  @Autowired
  private EffettuapManager epm;

  @Autowired
  private EffettuaAsManager eam;

  @Autowired
  private InterceptorMail sender;

  @Autowired
  private PatientManager pm;

  @Autowired
  RadiografiaManager rm;

  @Autowired
  private Ryan ryan;

  public void insertSwab(Swab s, Patient p, String timestamp) {
    pm.createPatient(p);
    EffettuaP ep = new EffettuaP();
    ep.setCfP(p.getCf());
    ep.setTimestamp(timestamp);
    ep.setIdTampone(s.getId());
    sm.createSwab(s);
    if (s.getIsInterno()) {
      if(rm.findByCfPaziente(p.getCf()).isEmpty()){
        epm.createEffettuaP(ep);
        return;
      }
      ep.setGravity(ryan.getProba(s, p));
    }
    epm.createEffettuaP(ep);
  }

  public void insertSwab(Swab s, HealthWorker hw, String timestamp) {
    hwm.createHwr(hw);
    EffettuaAs eas = new EffettuaAs();
    eas.setCfAs(hw.getCf());
    eas.setTimestamp(timestamp);
    eas.setIdTampone(s.getId());
    sm.createSwab(s);
    eam.createEffettuaAs(eas);
  }

  public List<HealthWorker> getAll() {
    return hwm.findAll();
  }


  public Swab inserisciRisultato(Integer idTampone, String risultato) {
    Swab s = sm.findById(idTampone);
    s.setRisultato(risultato);
    sm.updateSwab(s);
    sender.sendMail(s);
    return s;
  }

  public List<Swab> findAllSwab() {
    return sm.findAll();
  }

  public void insertHealthWorker(HealthWorker hw) {
    hw.setUsername(RandomString.make(10));
    hw.setPassword(RandomString.make(10));
    hwm.createHwr(hw);
  }
  public List<Swab> findSwabByCF(String cf) {
    return epm.findByCF(cf);
  }
}
