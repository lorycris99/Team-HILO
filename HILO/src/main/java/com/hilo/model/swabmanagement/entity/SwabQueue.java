package com.hilo.model.swabmanagement.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.AbstractQueue;
import java.util.PriorityQueue;

@Component
public class SwabQueue {

  private SwabQueue(){

  }

  public AbstractQueue<Swab> getInstance() {
    if (coda == null) {
      coda = new PriorityQueue<>();
    }
    return coda;
  }

  public boolean enqueue(Swab s) {

    return coda.add(s);
  }

  private static PriorityQueue<Swab> coda = null;
  @Autowired
  private SwabManager swabManager;
}
