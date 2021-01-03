package com.hilo.model.swabmanagement.entity;

import java.util.PriorityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwabQueue {

  private SwabQueue() {
    coda = new PriorityQueue<>(new SwabComparator());
  }

  public synchronized static SwabQueue getInstance() {
    if (istanza == null) {
      istanza = new SwabQueue();
    }
    return istanza;
  }

  public boolean enqueue(Swab s) {

    System.out.println(coda);
    return coda.add(s);
  }

  public Swab getTop() {
    return coda.poll();
  }

  public int getQueueSize() {
    return coda.size();
  }

  public Object[] getQueueArray() {
    return  coda.toArray();
  }

  private PriorityQueue<Swab> coda;
  private static SwabQueue istanza = null;
  @Autowired
  private SwabManager swabManager;
}
