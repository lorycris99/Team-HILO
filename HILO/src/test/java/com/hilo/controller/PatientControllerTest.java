package com.hilo.controller;

import com.hilo.model.patientmanagement.entity.Patient;
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
@DisplayName("JUnit 5 PatientControllerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientControllerTest {

  private Patient patient = null;

  @Autowired
  private PatientController controller;

  @Test
  @Order(1)
  public void registerAndGetByCfPatientTest() {
    String cf = "PRTGMN56D26B301S";
    String name = "Giacomo";
    String surname = "Poretti";
    String mail = "hilo.result@gmail.com";
    String telefono = "333333333";
    boolean isInterno = true;
    String indirizzo = "Via Milano 126";
    patient = controller.registerPatient(cf, name, surname, mail, telefono, isInterno, indirizzo);
    Assertions.assertEquals(patient, controller.getPazienteByCf("PRTGMN56D26B301S"));
    Patient patient1 = controller.registerPatient(cf, name, surname, 
                        mail, telefono, isInterno, indirizzo);
    Assertions.assertNull(patient1);
  }

  @Test
  @Order(2)
  public void getAllPatientsTests() {
    List<Patient> patients = controller.getAll();
    for (Patient p : patients) {
      Assertions.assertEquals(p, controller.getPazienteByCf(p.getCf()));
    } 
  }

  @Test
  @Order(3)
  public void cleanUp() {
    controller.deletePaziente(patient);
  }
}
