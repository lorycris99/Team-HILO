package com.hilo.model.swabmanagement.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class SwabQueueTest {

  @Autowired(required = true)
  private SwabManager sm;
  @Autowired(required = true)
  private EffettuapManager epm;
  @Autowired(required = true)
  private EffettuaAsManager eam;

  public void testFunzione() {
    SwabQueue queue = SwabQueue.getInstance();
//    SwabManager sm = new SwabManager();
    System.out.println("###" + sm);
//    EffettuaAsManager eam = new EffettuaAsManager();
//    EffettuapManager epm = new EffettuapManager();
    System.out.println("epm: " + epm.toString());

    System.out.println(sm.test());
//    Swab s1 = sm.findById(4);
//    EffettuaAs as1 = eam.findEffettuaAsByIdTampone(4);
//    Swab s2 = sm.findById(2);
//    EffettuaP ep2 = epm.findEffettuapByIdTampone(2);
//
//    System.out.println("oracolo true, effettivo: " + queue.enqueue(s2));
//    System.out.println("oracolo true, effettivo: " + queue.enqueue(s1));
//
//    System.out.println("lista: " + queue.getQueueArray());
  }
}
