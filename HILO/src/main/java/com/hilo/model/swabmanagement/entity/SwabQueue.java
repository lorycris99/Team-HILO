package com.hilo.model.swabmanagement.entity;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SwabQueue {

  @Autowired
  private SwabComparator sc;

  private SwabQueue() {
    coda = new PriorityQueue<Swab>(sc);
  }

  public static SwabQueue getInstance() {
    if (istanza == null) {
      istanza = new SwabQueue();
    }
    return istanza;
  }

  public boolean enqueue(Swab s) {

    return coda.add(s);
  }

  public Swab getTop() {
    return coda.poll();
  }

  public int getQueueSize() {
    return coda.size();
  }

  public Object[] getQueueArray() {
    return coda.toArray();
  }

  private PriorityQueue<Swab> coda;
  private static SwabQueue istanza = null;

}
