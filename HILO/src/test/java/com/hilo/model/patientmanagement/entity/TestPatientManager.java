package com.hilo.model.patientmanagement.entity;

import com.hilo.model.patientmanagement.repository.PatientRepository;
import org.aspectj.weaver.UnresolvedType;
import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 PatientManager")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestPatientManager{

  @Autowired
  private PatientRepository repo;

  @Autowired
  private PatientManager manager;
  @Test
  @Order(10) //ultimo metodo da eseguire
  public  void deletePaziente(){
    manager.deletePatient(manager.findById("4321"));
    Assertions.assertEquals(null, manager.findById("4321"));

  }

  @Test
  @Order(1)
  public void creaPazienteTest(){
    Patient p = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");

    manager.createPatient(p);
    Assertions.assertEquals(p, manager.findById("4321"));
  }

  @Test
  @Order(2)
  public void findByIdTest(){
    Patient x=manager.findById("4321");
    Assertions.assertEquals(x,manager.findByUsernameAndPassword("user","pass"));
  }

  @Test
  @Order(3)
  public void findByUsernameAndPasswordTest(){
    Patient x=manager.findByUsernameAndPassword("user","pass");
    Assertions.assertEquals(x,manager.findById("4321"));

  }

  @Test
  @Order(4)
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
    Assertions.assertEquals(lista,temp);

  }

  @Test
  @Order(5)
  public void findByTelefonoTest(){
    Patient x=manager.findByTelefono("33333");
    String cf=x.getCf();
    Assertions.assertEquals(x,manager.findById(cf));
  }
  @Test
  @Order(6)
  public void findByEmailTest(){
    Patient x=manager.findByMail("lmao@yeah.lol");
    String cf=x.getCf();
    Assertions.assertEquals(x,manager.findById(cf));
  }

  @Test
  @Order(7)
  public void findByCognomeTest(){
    List<Patient> lista=manager.findByCognome("yeah");
    List<Patient> all=manager.findAll();
    boolean result=true;
    List<Patient> temp=new ArrayList<>();
    for(int i=0;i<lista.size() && result==true ;i++){
      if (all.contains(lista.get(i))){
        result=true;
        temp.add(lista.get(i));
      }
      else{
        result=false;
      }
    }
    Assertions.assertEquals(lista,temp);
    }
  @Test
  @Order(8)
  public void findAllTest(){
    List<Patient>lista=manager.findByIsInterno(true);
    List<Patient>lista2=manager.findByIsInterno(false);
    for(int i=0;i<lista2.size();i++){
      lista.add(lista2.get(i));
    }
    Assertions.assertEquals(lista.size(),manager.findAll().size());
  }

  @Test
  @Order(9)
  public void creaPazienteTest2(){
    Patient p = new Patient("4321", "user", "pass", "lmao@yeah.lol", "33333", false, "via kek 24", "lmao", "yeah");
    Assertions.assertThrows(IllegalStateException.class, () -> {
      manager.createPatient(p);
    });

  }


}
