package com.hilo.model.swab;
import com.hilo.model.swabmanagement.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 Example3")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSwab {
    @Autowired
    private SwabManager sm;
    @Autowired
    private EffettuapManager epm;
    @Autowired
    private EffettuaAsManager eam;
    @Autowired
    private SwabQueue swq;
    

    @Test
    @Order(1)
    public void testLista(){
        Swab interno, esternoP, esternoA, internoTest;
        interno = sm.findById(1);
        esternoP = sm.findById(7);
        esternoA = sm.findById(2);
        internoTest = sm.findById(4);
        swq.enqueue(esternoA);
        System.out.println("Inserito 1");
        swq.enqueue(esternoP);
        System.out.println("Inserito 2");
        swq.enqueue(interno);
        System.out.println("Inserito 3");
        swq.enqueue(internoTest);
//        System.out.println(swq.);
        Assertions.assertEquals(internoTest, swq.getTop());
        Assertions.assertEquals(interno, swq.getTop());
        Assertions.assertEquals(esternoA, swq.getTop());
        Assertions.assertEquals(esternoP, swq.getTop());

    }

    @Test
    @Order(1)
    public void testId(){
        Swab s=new Swab();
        s.setId(12);
        Assertions.assertEquals(s.getId(),12);
    }

    @Test
    @Order(2)
    public void testResultato(){
        Swab s=new Swab();
        s.setRisultato("test");
        Assertions.assertEquals(s.getRisultato(),"test");
    }

    @Test
    @Order(3)
    public void testInterno(){
        Swab s=new Swab();
        s.setIsInterno(true);
        Assertions.assertEquals(s.getIsInterno(),true);
    }

    @Test
    @Order(4)
    public void testIdStruttura(){
        Swab s=new Swab();
        s.setIdStruttura(100);
        Assertions.assertEquals(s.getIdStruttura(),100);
    }




}
