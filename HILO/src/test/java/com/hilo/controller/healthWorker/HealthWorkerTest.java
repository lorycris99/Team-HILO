package com.hilo.controller.healthWorker;


import com.hilo.controller.HealthController;
import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.healthworkermanagement.entity.HealthWorkerManager;
import com.hilo.model.patientmanagement.entity.Patient;
import com.hilo.model.patientmanagement.entity.PatientManager;
import com.hilo.model.swabmanagement.entity.EffettuaAs;
import com.hilo.model.swabmanagement.entity.EffettuaAsManager;
import com.hilo.model.swabmanagement.entity.EffettuaP;
import com.hilo.model.swabmanagement.entity.EffettuapManager;
import com.hilo.model.swabmanagement.entity.Swab;
import com.hilo.model.swabmanagement.entity.SwabManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 HealthWorkerControllerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HealthWorkerTest {

  @Autowired
  private HealthController controller;

  @Autowired
  private PatientManager pm;

  @Autowired
  private HealthWorkerManager hwm;

  @Autowired
  private SwabManager sm;

  @Autowired
  private EffettuaAsManager eam;

  @Autowired
  private EffettuapManager epm;

  @Test
  @Order(1)
  public void insertSwabPatient() {
    Patient p = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333",
            false, "via kek 24", "lmao", "yeah");
    String timestamp = "09-01-2021 07:45";
    Swab s = new Swab();
    s.setId(25);
    s.setRisultato("");
    s.setIdStruttura(1);
    s.setIsInterno(false);
    controller.insertSwab(s, p, timestamp);
    EffettuaP temp = new EffettuaP();
    temp.setTimestamp(timestamp);
    temp.setCfP(p.getCf());
    temp.setIdTampone(s.getId());
    Assertions.assertEquals(p, pm.findById(p.getCf()));
    Assertions.assertEquals(s, sm.findById(s.getId()));
    Assertions.assertEquals(temp, epm.findEffettuapByIdTampone(s.getId()));
  }

  @Test
  @Order(2)
  public void insertSwabPatientInterno() {
    Patient p = pm.findById("FRTGRD99A01F912U");
    String timestamp = "09-01-2021 08:45";
    Swab s = new Swab();
    s.setId(26);
    s.setRisultato("");
    s.setIdStruttura(1);
    s.setIsInterno(true);
    controller.insertSwab(s, p, timestamp);
    EffettuaP temp = new EffettuaP();
    temp.setTimestamp(timestamp);
    temp.setCfP(p.getCf());
    temp.setIdTampone(s.getId());
    temp.setGravity(0.76);
    Assertions.assertEquals(p, pm.findById(p.getCf()));
    Assertions.assertEquals(s, sm.findById(s.getId()));
    Assertions.assertEquals(temp, epm.findEffettuapByIdTampone(s.getId()));
  }

  @Test
  @Order(3)
  public void insertSwabAs() {
    HealthWorker hw = hwm.findById("CNTGPP64M08M131X");
    Swab s = new Swab();
    String timestamp = "10-01-2021 08:45";
    s.setId(27);
    s.setRisultato("");
    s.setIdStruttura(1);
    s.setIsInterno(false);
    controller.insertSwab(s, hw, timestamp);
    EffettuaAs temp = new EffettuaAs();
    temp.setTimestamp(timestamp);
    temp.setCfAs(hw.getCf());
    temp.setIdTampone(s.getId());
    Assertions.assertEquals(hw, hwm.findById(hw.getCf()));
    Assertions.assertEquals(s, sm.findById(s.getId()));
    Assertions.assertEquals(temp, eam.findEffettuaAsByIdTampone(s.getId()));
  }

  @Test
  @Order(7)
  public void delete() {
    epm.removeEffettuaP(epm.findEffettuapByIdTampone(25));
    epm.removeEffettuaP(epm.findEffettuapByIdTampone(26));
    eam.deleteEffettuaAs(eam.findEffettuaAsByIdTampone(27));
    pm.deletePatient(pm.findById("4321"));
    sm.deleteSwab(sm.findById(25));
    sm.deleteSwab(sm.findById(26));
    sm.deleteSwab(sm.findById(27));
    Assertions.assertNull(pm.findById("4321"));
    Assertions.assertNull(sm.findById(25));
    Assertions.assertNull(sm.findById(26));
    Assertions.assertNull(sm.findById(27));
    Assertions.assertNull(epm.findEffettuapByIdTampone(25));
    Assertions.assertNull(epm.findEffettuapByIdTampone(26));
    Assertions.assertNull(eam.findEffettuaAsByIdTampone(27));
  }

  @Test
  @Order(4)
  public void getAllWorkers(){
    List<HealthWorker> list = controller.getAll();
    for(HealthWorker t : list){
      Assertions.assertEquals(t, hwm.findById(t.getCf()));
    }
  }

  @Test
  @Order(5)
  public void inserisciRisultato(){
    controller.inserisciRisultato(26, "positivo");
    Assertions.assertEquals(sm.findById(26).getRisultato(), "positivo");
  }

  @Test
  @Order(6)
  public void findAllSwab(){
    List<Swab> list = controller.findAllSwab();
    for(Swab t : list){
      Assertions.assertEquals(t, sm.findById(t.getId()));
    }
  }
}
