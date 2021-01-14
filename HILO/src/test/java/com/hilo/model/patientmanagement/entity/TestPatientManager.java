package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.PatientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPatientManager {

  @Autowired
  private PatientRepository repo;

  @Autowired
  private PatientManager manager;

  @Test
  public void creaPazienteTest(){
    Patient p = new Patient("1234", "user", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");

    manager.creaPaziente(p);
    Assert.assertEquals(p, manager.findById("1234"));
  }
}
