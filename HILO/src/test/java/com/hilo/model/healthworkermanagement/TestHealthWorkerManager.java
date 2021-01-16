package com.hilo.model.healthworkermanagement;

import com.hilo.model.adminmanagement.entity.StrutturaManager;
import com.hilo.model.healthworkermanagement.entity.HealthWorker;
import com.hilo.model.healthworkermanagement.entity.HealthWorkerManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 HealthWorkerManagerTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestHealthWorkerManager {
    @Autowired
    private HealthWorkerManager manager;

    @Test
    @Order(1)
    public void findIdTest(){
        HealthWorker temp=null;
        List<HealthWorker> all=manager.findAll();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getCf().equals("admin")){
                temp=all.get(i);
            }
        }
        Assertions.assertEquals(manager.findById("admin"), temp);
        Assertions.assertNull(manager.findById("test"));
    }
    @Test
    @Order(2)
    public void createTest(){
        HealthWorker h=new HealthWorker();
        HealthWorker r=new HealthWorker();
        h.setCf("admin");
        h.setIdstruttura(1);
        Assertions.assertEquals(false,manager.createHwr(h));
        r.setCf("lll"); r.setIdstruttura(1); r.setCognome("q"); r.setIndirizzo("o");
        r.setMail("m"); r.setNome("n"); r.setUsername("l"); r.setPassword("pp");
        r.setRuolo("dottore"); r.setTelefono("123456");
        Assertions.assertEquals(true,manager.createHwr(r));
        manager.deleteHwr(manager.findById("lll"));

    }

}
