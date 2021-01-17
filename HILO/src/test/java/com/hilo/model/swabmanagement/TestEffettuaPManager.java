package com.hilo.model.swabmanagement;

import com.hilo.model.swabmanagement.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 EffettuaPManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEffettuaPManager {
    @Autowired
    EffettuapManager manager;
    @Autowired
    SwabManager m;

    @Test
    @Order(1)
    public void findIdTest(){
        List<EffettuaP> all=manager.findAll();
        EffettuaP temp=null;
        for(int i=0;i<all.size();i++){
            if((all.get(i).getCfP().equals("DMAVCR00A10F912V")) && (all.get(i).getIdTampone()==2)){
                temp=all.get(i);
            }
        }
        EmbeddedEffettuaP id=new EmbeddedEffettuaP();
        id.setCfP("DMAVCR00A10F912V"); id.setIdTampone(2);
        EffettuaP x=new EffettuaP();
        Assertions.assertEquals(manager.findById(id), temp);
        EmbeddedEffettuaP e=new EmbeddedEffettuaP();
        e.setIdTampone(100); e.setCfP("bbbb");
        Assertions.assertNull(manager.findById(e));
    }

    @Test
    @Order(2)
    public void findIdTamponeTest(){
        List<EffettuaP> all=manager.findAll();
        Swab temp=null;
        for(int i=0;i<all.size();i++){
            if(all.get(i).getIdTampone()==2){
                temp=m.findById(all.get(i).getIdTampone());
            }
        }
        Assertions.assertEquals(manager.findByIdTampone(2), temp);
//        Assertions.assertNull(manager.findByIdTampone(100));

    }

    @Test
    @Order(3)
    public void findCFTest(){
        List<EffettuaP> all=manager.findAll();
        List<EffettuaP> temp=new ArrayList<>();
        List<Swab> temp2=new ArrayList<>();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getCfP().equals("FRTGRD99A01F912U")){
                temp.add(all.get(i));
            }
        }
        for(int i=0;i<temp.size();i++){
            temp2.add(m.findById(temp.get(i).getIdTampone()));
        }
        Assertions.assertEquals(manager.findByCF("FRTGRD99A01F912U"), temp2);
    }
}

