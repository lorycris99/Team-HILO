package com.hilo.model.swab;
import com.hilo.model.swabmanagement.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JUnit 5 Example3")
public class TestSwab {
    @Autowired
    private SwabManager sm;
    @Autowired
    private EffettuapManager epm;
    @Autowired
    private EffettuaAsManager eam;

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
}
