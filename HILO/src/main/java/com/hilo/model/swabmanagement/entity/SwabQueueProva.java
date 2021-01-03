package com.hilo.model.swabmanagement.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class SwabQueueProva {

  @Autowired
  private SwabManager sm;
  @Autowired
  private EffettuapManager epm;
  @Autowired
  private EffettuaAsManager eam;

  public String testFunzione() {
    SwabQueue queue = SwabQueue.getInstance();
//    SwabManager sm = new SwabManager();
    System.out.println("###" + sm);
//    EffettuaAsManager eam = new EffettuaAsManager();
//    EffettuapManager epm = new EffettuapManager();
    System.out.println("epm: " + epm);

    Swab s1 = sm.findById(4);
    EffettuaAs as1 = eam.findEffettuaAsByIdTampone(4);
    Swab s2 = sm.findById(2);
    EffettuaP ep2 = epm.findEffettuapByIdTampone(2);

    System.out.println("oracolo true, effettivo: " + queue.enqueue(s2));
    System.out.println("oracolo true, effettivo: " + queue.enqueue(s1));

    System.out.println("lista: " + queue.getQueueArray());
    return "doppio ok";
  }


}
