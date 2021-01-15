package com.hilo.model.swab;
import com.hilo.model.swabmanagement.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("JUnit 5 Example3")
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
    public void testFunzione() {
        SwabQueue queue = SwabQueue.getInstance();
        System.out.println("###" + sm);
        Assertions.assertNotNull(queue);

        Swab s1 = sm.findById(4);
        EffettuaAs as1 = eam.findEffettuaAsByIdTampone(4);
        Swab s2 = sm.findById(2);
        EffettuaP ep2 = epm.findEffettuapByIdTampone(2);

        Assertions.assertTrue(queue.enqueue(s2));
        Assertions.assertTrue(queue.enqueue(s1));

        System.out.println(queue.getQueueArray());
    }

    @Test
    public void testLista(){
        Swab interno, esternoP, esternoA;
        interno = sm.findById(1);
        esternoP = sm.findById(7);
        esternoA = sm.findById(2);
        swq.enqueue(esternoA);
        swq.enqueue(esternoP);
        swq.enqueue(interno);
        Assertions.assertEquals(interno, swq.getTop());
        Assertions.assertEquals(interno, swq.getTop());
        Assertions.assertEquals(esternoP, swq.getTop());
    }
}