package com.hilo.model.swabmanagement;

import com.hilo.model.swabmanagement.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 EffettuaAsManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEffettuaAsManager {
    @Autowired
    private EffettuaAsManager manager;
    @Autowired
    private SwabManager m;
    //SPSCRI77P19F839Y 4

    @Test
    @Order(1)
    public void findIdTest(){
        EffettuaAs temp=null;
        EmbeddedEffettuaAs id=new EmbeddedEffettuaAs();
        id.setCfAs("SPSCRI77P19F839Y"); id.setIdTampone(4);
        List<EffettuaAs> all=manager.findAll();
            for(int i=0;i<all.size();i++){
                if((all.get(i).getIdTampone()==4) && (all.get(i).getCfAs().equals("SPSCRI77P19F839Y"))){
                    temp=all.get(i);
                }
            }
        Assertions.assertEquals(manager.findById(id),temp);
            id.setIdTampone(100);
        Assertions.assertNull(manager.findById(id));
    }

    @Test
    @Order(2)
    public void findIdTamponeTest(){
        Assertions.assertEquals(manager.findByIdTampone(4),m.findById(4));
        Assertions.assertNull(manager.findByIdTampone(99));
    }
    @Test
    @Order(3)
    public void findEffettuaAsByIdTamponeTest(){
        List<EffettuaAs> all=manager.findAll();
        EffettuaAs temp=null;
        for(int i=0;i<all.size();i++){
            if(all.get(i).getIdTampone()==4){
                temp=all.get(i);
            }
        }
        Assertions.assertEquals(manager.findEffettuaAsByIdTampone(4),temp);
    }
    @Test
    @Order(4)
    public void findByCfAsTest(){
        List<EffettuaAs> all=manager.findAll();
        List<EffettuaAs> temp=new ArrayList<EffettuaAs>();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getCfAs().equals("SPSCRI77P19F839Y")){
                temp.add(all.get(i));
            }
        }
        Assertions.assertEquals(manager.findByCfAs("SPSCRI77P19F839Y"),temp);
    }

    @Test
    @Order(5)
    public void findByTime(){
        String t1="2020-11-09";
        String t2="2020-11-13";
        List<Integer> lista=new ArrayList<Integer>();
        System.out.println(manager.findTimestampBetween(t1,t2));
        Assertions.assertNotEquals(manager.findTimestampBetween(t1,t2),lista);

    }

}
