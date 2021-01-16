package com.hilo.model.swabmanagement;

import com.hilo.model.swabmanagement.entity.Swab;
import com.hilo.model.swabmanagement.entity.SwabManager;

import java.util.ArrayList;
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
@DisplayName("JUnit 5 SwabManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSwabManager {
  @Autowired
  private SwabManager manager;
    
  @Test
  @Order(1)
  public void findAllTest() {
    List<Swab> lista = manager.findByInterno(true);
    List<Swab> lista2 = manager.findByInterno(false);
    for (int i = 0; i < lista2.size(); i++) {
      lista.add(lista2.get(i));
    }
    Assertions.assertEquals(manager.findAll().size(), lista.size());
  }

  @Test
  @Order(2)
  public void findIdTest() {
    Swab s = new Swab();
    s.setId(666);
    s.setIdStruttura(1);
    s.setIsInterno(true);
    s.setRisultato("");
    manager.createSwab(s);
    List<Swab> lista = manager.findByStruttura(1);
    Swab s2 = null;
    for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getId() == 666) {
        s2 = lista.get(i);
      }
    }
    Assertions.assertEquals(manager.findById(666), s2);
  }
    
  @Test
  @Order(6)
  public void deleteTest() {
    manager.deleteSwab(manager.findById(666));
    Assertions.assertNull(manager.findById(666));
  }

  @Test
  @Order(3)
  public void findEsitoTest(){
    List<Swab>lista=manager.findByEsito("");
    List<Swab>all=manager.findAll();
    List<Swab>temp= new ArrayList<Swab>();
    for(int i=0;i<all.size();i++){
      if(all.get(i).getRisultato().equals("")){
        temp.add(all.get(i));
      }
    }
    Assertions.assertEquals(lista,temp);
  }

  @Test
  @Order(4)
  public void findInternoTest(){
    List<Swab>lista=manager.findByInterno(true);
    List<Swab>all=manager.findAll();
    List<Swab>temp= new ArrayList<Swab>();
    for(int i=0;i<all.size();i++){
      if(all.get(i).getIsInterno()==true){
        temp.add(all.get(i));
      }
    }
    Assertions.assertEquals(lista,temp);
  }

  @Test
  @Order(5)
  public void findStrutturaTest(){
    List<Swab>lista=manager.findByStruttura(1);
    List<Swab>all=manager.findAll();
    List<Swab>temp= new ArrayList<Swab>();
    for(int i=0;i<all.size();i++){
      if(all.get(i).getIdStruttura()==1){
        temp.add(all.get(i));
      }
    }
    Assertions.assertEquals(lista,temp);
  }



}
