package com.hilo.controller;

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
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 HealthWorkerControllerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HealthWorkerTest {

  private static Swab s1 = new Swab();
  private static Swab s2 = new Swab();

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
    s2.setRisultato("");
    s2.setIdStruttura(1);
    s2.setIsInterno(false);
    Patient p = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333",
                            false, "via kek 24", "lmao", "yeah");
    String timestamp = "09-01-2021 07:45";
    controller.insertSwab(s2, p, timestamp);
    EffettuaP temp = new EffettuaP();
    temp.setTimestamp(timestamp);
    temp.setCfP(p.getCf());
    temp.setIdTampone(s2.getId());
    Assertions.assertEquals(p, pm.findById(p.getCf()));
    Assertions.assertEquals(s2, sm.findById(s2.getId()));
    Assertions.assertEquals(temp, epm.findEffettuapByIdTampone(s2.getId()));
  }

  @Test
  @Order(2)
  public void insertSwabPatientInterno() {
    s1.setRisultato("");
    s1.setIdStruttura(1);
    s1.setIsInterno(true);
    Patient p = pm.findById("FRTGRD99A01F912U");
    String timestamp = "09-01-2021 08:45";
    controller.insertSwab(s1, p, timestamp);
    EffettuaP temp = new EffettuaP();
    temp.setTimestamp(timestamp);
    temp.setCfP(p.getCf());
    temp.setIdTampone(s1.getId());
    temp.setGravity(0.76);
    Assertions.assertEquals(p, pm.findById(p.getCf()));
    Assertions.assertEquals(s1, sm.findById(s1.getId()));
    Assertions.assertEquals(temp, epm.findEffettuapByIdTampone(s1.getId()));
  }

  @Test
  @Order(3)
  public void insertSwabAs() {
    Swab s = new Swab();
    s.setRisultato("");
    s.setId(27);
    s.setIdStruttura(1);
    s.setIsInterno(false);
    HealthWorker hw = hwm.findById("CNTGPP64M08M131X");
    String timestamp = "10-01-2021 08:45";
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
    epm.removeEffettuaP(epm.findEffettuapByIdTampone(s2.getId()));
    epm.removeEffettuaP(epm.findEffettuapByIdTampone(s1.getId()));
    eam.deleteEffettuaAs(eam.findEffettuaAsByIdTampone(27));
    pm.deletePatient(pm.findById("4321"));
    sm.deleteSwab(sm.findById(s2.getId()));
    sm.deleteSwab(sm.findById(s1.getId()));
    sm.deleteSwab(sm.findById(27));
    Assertions.assertNull(pm.findById("4321"));
    Assertions.assertNull(sm.findById(s2.getId()));
    Assertions.assertNull(sm.findById(s1.getId()));
    Assertions.assertNull(sm.findById(27));
    Assertions.assertNull(epm.findEffettuapByIdTampone(s2.getId()));
    Assertions.assertNull(epm.findEffettuapByIdTampone(s1.getId()));
    Assertions.assertNull(eam.findEffettuaAsByIdTampone(27));
  }

  @Test
  @Order(4)
  public void getAllWorkers() {
    List<HealthWorker> list = controller.getAll();
    for (HealthWorker t : list) {
      Assertions.assertEquals(t, hwm.findById(t.getCf()));
    }
  }

  @Test
  @Order(5)
  public void inserisciRisultato() {
    System.out.println(s1.getId());
    controller.inserisciRisultato(s1.getId(), "positivo");
    Assertions.assertEquals(sm.findById(s1.getId()).getRisultato(), "positivo");
  }

  @Test
  @Order(6)
  public void findAllSwab() {
    List<Swab> list = controller.findAllSwab();
    for (Swab t : list) {
      Assertions.assertEquals(t, sm.findById(t.getId()));
    }
  }
}
