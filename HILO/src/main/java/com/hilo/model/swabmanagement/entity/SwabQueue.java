package com.hilo.model.swabmanagement.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.AbstractQueue;
import java.util.PriorityQueue;

@Component
public class SwabQueue {

  private SwabQueue(){

  }

  public static SwabQueue getInstance() {
    if (istanza == null) {
      istanza = new SwabQueue();
      //coda = new PriorityQueue<>(new SwabComparator());
    }
    return istanza;
  }

  public boolean enqueue(Swab s) {

    return coda.add(s);
  }

  private PriorityQueue<Swab> coda;
  private static SwabQueue istanza = null;
  @Autowired
  private SwabManager swabManager;
}
