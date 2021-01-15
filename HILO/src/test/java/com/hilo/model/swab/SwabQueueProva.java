package com.hilo.model.swab;
import com.hilo.model.swabmanagement.entity.EffettuaAsManager;
import com.hilo.model.swabmanagement.entity.EffettuapManager;
import com.hilo.model.swabmanagement.entity.SwabManager;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest
public class SwabQueueProva  {
  @Autowired
  private SwabManager sm;
  @Autowired
  private EffettuapManager epm;
  @Autowired
  private EffettuaAsManager eam;

 /* @Test
  public void testFunzione() {
    SwabQueue queue = SwabQueue.getInstance();
    System.out.println("###" + sm);
    Assert.assertNotNull(queue);

    Swab s1 = sm.findById(4);
    EffettuaAs as1 = eam.findEffettuaAsByIdTampone(4);
    Swab s2 = sm.findById(2);
    EffettuaP ep2 = epm.findEffettuapByIdTampone(2);

    Assert.assertTrue(queue.enqueue(s2));
    Assert.assertTrue(queue.enqueue(s1));

    System.out.println(queue.getQueueArray());
  }*/
}
