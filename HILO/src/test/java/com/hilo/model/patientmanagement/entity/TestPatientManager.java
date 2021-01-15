package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.PatientRepository;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPatientManager extends TestCase {

  @Autowired
  private PatientRepository repo;

  @Autowired
  private PatientManager manager;

  @Test
  public void deletePaziente(){
    manager.deletePatient(manager.findById("4321"));
  }

  @Test
  public void creaPazienteTest(){
    Patient p = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");

    manager.createPatient(p);
    Assert.assertEquals(p, manager.findById("4321"));
  }

  @Test
  public void findByIdTest(){
    Patient x=manager.findById("4321");
    Assert.assertEquals(x,manager.findByUsernameAndPassword("user","pass"));
  }

  @Test
  public void findByUsernameAndPasswordTest(){
    Patient x=manager.findByUsernameAndPassword("user","pass");
    Assert.assertEquals(x,manager.findById("4321"));

  }

}
