package com.hilo.model.swab;

import com.hilo.model.swabmanagement.entity.EffettuaAs;
import com.hilo.model.swabmanagement.entity.EffettuaAsManager;
import com.hilo.model.swabmanagement.entity.EffettuaP;
import com.hilo.model.swabmanagement.entity.EffettuapManager;
import com.hilo.model.swabmanagement.entity.Swab;
import com.hilo.model.swabmanagement.entity.SwabManager;
import com.hilo.model.swabmanagement.entity.SwabQueue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SwabQueueTest {
  @Autowired
  private SwabManager sm;
  @Autowired
  private EffettuapManager epm;
  @Autowired
  private EffettuaAsManager eam;

  @Test
  public void testFunzione() {
    SwabQueue queue = SwabQueue.getInstance();
//    SwabManager sm = new SwabManager();
    System.out.println("###" + sm);
//    EffettuaAsManager eam = new EffettuaAsManager();
//    EffettuapManager epm = new EffettuapManager();
    Assert.assertNotNull(queue);

    Swab s1 = sm.findById(4);
    EffettuaAs as1 = eam.findEffettuaAsByIdTampone(4);
    Swab s2 = sm.findById(2);
    EffettuaP ep2 = epm.findEffettuapByIdTampone(2);

    Assert.assertTrue(queue.enqueue(s2));
    Assert.assertTrue(queue.enqueue(s1));

    System.out.println(queue.getQueueArray());
  }
}