package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.PatientRepository;
import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 Example")
public class TestPatientManager{

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

  @Test
  public void findByIsInternoTest(){
    List<Patient> lista=manager.findByIsInterno(true);
    List<Patient> all=manager.findAll();
    List<Patient> temp=new ArrayList<>();
    boolean result=true;
    for(int i=0;i<lista.size() && result==true ;i++){
      if (all.contains(lista.get(i))){
        result=true;
        temp.add(lista.get(i));
      }
      else{
        result=false;
      }
    }
    Assert.assertEquals(lista,temp);

  }

  @Test
  public void findByTelefonoTest(){
    Patient x=manager.findByTelefono("33333");
    String cf=x.getCf();
    Assert.assertEquals(x,manager.findById(cf));
  }
  @Test
  public void findByEmail(){
    Patient x=manager.findByMail("lmao@yeah.lol");
    String cf=x.getCf();
    Assert.assertEquals(x,manager.findById(cf));
  }

}
