package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 PatientTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestPatient {
  private Patient patient = null;

  @Test
  @Order(1)
  public void cfTest() {
    patient = new Patient();
    patient.setCf("999999");
    Assertions.assertEquals(patient.getCf(), "999999");
  }

  @Test
  @Order(2)
  public void usernameTest() {
    patient = new Patient();
    patient.setUsername("test");
    Assertions.assertEquals(patient.getUsername(), "test");
  }

  @Test
  @Order(3)
  public void passwordTest() {
    patient = new Patient();
    patient.setPassword("pass");
    Assertions.assertEquals(patient.getPassword(), "pass");
  }

  @Test
  @Order(4)
  public void mailTest() {
    patient = new Patient();
    patient.setMail("mail");
    Assertions.assertEquals(patient.getMail(), "mail");
  }

  @Test
  @Order(5)
  public void telefonoTest() {
    patient = new Patient();
    patient.setTelefono("tell");
    Assertions.assertEquals(patient.getTelefono(), "tell");
  }

  @Test
  @Order(6)
  public void internoTest() {
    patient = new Patient();
    patient.setIsInterno(true);
    Assertions.assertEquals(patient.getIsInterno(), true);
  }

  @Test
  @Order(7)
  public void indirizzoTest() {
    patient = new Patient();
    patient.setIndirizzo("indirizzo");
    Assertions.assertEquals(patient.getIndirizzo(), "indirizzo");
  }

  @Test
  @Order(8)
  public void nomeTest() {
    patient = new Patient();
    patient.setNome("nome");
    Assertions.assertEquals(patient.getNome(), "nome");
  }

  @Test
  @Order(9)
  public void cognomeTest() {
    patient = new Patient();
    patient.setCognome("cognome");
    Assertions.assertEquals(patient.getCognome(), "cognome");
  }

  @Test
  @Order(10)
  public void equalsTest() {
    Patient patientA = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", 
              false, "via kek 24", "lmao", "yeah");
    Patient patientB = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333",
              false, "via kek 24", "lmao", "yeah");
    Assertions.assertEquals(true, patientA.equals(patientB));
    Assertions.assertEquals(true, patientA.equals(patientA));
    Assertions.assertEquals(false, patientA.equals(null));
    Assertions.assertEquals(false, patientA.equals(""));
    Patient patientC = new Patient("4321", "user2", "pass", "lmao@yeah.lol", "33333", 
              false, "via kek 24", "lmao", "yeah");
    Patient patientD = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", 
              false, "via kek 24", "lmao", "yeah");
    Assertions.assertEquals(false, patientC.equals(patientD));
    Patient patientE = new Patient("4321", "user2", "pass2", "lmao@yeah.lol", "33333",
              false, "via kek 24", "lmao", "yeah");
    Patient patientF = new Patient("4321", "user2", "pass", "lmao@yeah.lol", "33333",
              false, "via kek 24", "lmao", "yeah");
    Assertions.assertEquals(false, patientE.equals(patientF));
    Patient patientG = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", 
              "33333", false, "via kek 24", "lmao", "yeah");
    Patient patientH = new Patient("4321", "user2", "pass2", "lmao@yeah.lol", 
              "33333", false, "via kek 24", "lmao", "yeah");
    Assertions.assertEquals(false, patientG.equals(patientH));
    Patient patientI = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "33333",
              false, "via kek 24", "lmao", "yeah");
    Patient patientL = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "33333", 
              true, "via kek 24", "lmao", "yeah");
    Assertions.assertEquals(false, patientI.equals(patientL));
    Patient patientM = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              true, "via kek 24", "lmao", "yeah");
    Patient patientN = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              false, "via kek 24", "lmao", "yeah");
    Assertions.assertEquals(false, patientM.equals(patientN));
    Patient patientO = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              true, "via kek 244", "lmao", "yeah");
    Patient patientP = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              true, "via kek 24", "lmao", "yeah");
    Assertions.assertEquals(false, patientO.equals(patientP));
    Patient patientQ = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              true, "via kek 244", "lmapo", "yeah");
    Patient patientR = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              true, "via kek 244", "lmao", "yeah");
    Assertions.assertEquals(false, patientQ.equals(patientR));
    Patient patientS = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              true, "via kek 244", "lmapo", "yeahg");
    Patient patientT = new Patient("4321", "user2", "pass2", "lmvao@yeah.lol", "333633", 
              true, "via kek 244", "lmapo", "yeah");
    Assertions.assertEquals(false, patientS.equals(patientT));
  }
}
