package com.hilo.model.patientmanagement.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 PaginaDiarioClinicoManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPaginaDiarioClinicoManager {
    @Autowired
    PaginaDiarioClinicoManager manager;

    @Test
    @Order(1)
    public void findIdTest(){
        List<PaginaDiarioClinico> all=manager.findAll();
        PaginaDiarioClinico temp=null;
        for(int i=0;i<all.size();i++){
            if ((all.get(i).getCfPaziente().equals("FRTGRD99A01F912U")) && (all.get(i).getNumero()==1)){
                temp=all.get(i);
            }
        }
        Assertions.assertEquals(manager.findById(1, "FRTGRD99A01F912U"), temp);
        Assertions.assertNull(manager.findById(20,"abc"));
    }
}
