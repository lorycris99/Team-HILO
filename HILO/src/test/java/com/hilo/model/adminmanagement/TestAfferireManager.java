package com.hilo.model.adminmanagement;

import com.hilo.model.adminmanagement.entity.Afferire;
import com.hilo.model.adminmanagement.entity.AfferireManager;
import com.hilo.model.adminmanagement.entity.EmbeddedAfferire;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 AfferireManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAfferireManager {
    @Autowired
    private AfferireManager manager;

    @Test
    @Order(1)
    public void findIdTest(){
        List<Afferire> lista=manager.findAll();
        Afferire temp=null;
        EmbeddedAfferire id=new EmbeddedAfferire();
        id.setCfPaziente("DMAVCR00A10F912V");
        id.setIdStruttura(1);
        for(int i=0;i<lista.size();i++){
            if((lista.get(i).getCfpaziente().equals("DMAVCR00A10F912V")) && (lista.get(i).getIdstruttura()==1)){
                temp=lista.get(i);
            }
        }
        Assertions.assertEquals(manager.findById(id),temp);
        id.setIdStruttura(999);
        Assertions.assertEquals(manager.findById(id),null);

    }
}
