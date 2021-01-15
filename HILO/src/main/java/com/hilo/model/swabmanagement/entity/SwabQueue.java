package com.hilo.model.swabmanagement.entity;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Questa classe rappresenta una coda di tamponi da analizzare.
 */
@Component
public class SwabQueue {

  @Autowired
  private static SwabQueue queue;

  /**
   * Costruttore privato per rispettare il design pattern Singleton.
   */
  private SwabQueue() {

  }

  /**
   * Permette l'accesso ad una singola istanza della coda.
   *
   * @return la coda dei tamponi da effettuare
   */
  public static SwabQueue getInstance() {
    if (istanza == null) {
      istanza = queue;
    }
    return istanza;
  }

  /**
   * Permette di accodare un tampone nella coda, il quale finirà in una
   * posizione determinata dal timestamp e dalla percentuale di positivita'.
   *
   * @param s il tampone da accodare
   */
  public void enqueue(Swab s) {
    System.out.println("enqueue");
    coda.add(s);
  }

  /**
   * Restituisce il tampone da analizzare piu' urgente.
   *
   * @return un tampone da analizzare
   */
  public Swab getTop() {
    return coda.getTop();
  }

  /**
   * Restituisce la lunghezza totale della coda dei tamponi.
   *
   * @return la lunghezza della coda
   */
  public int getQueueSize() {
    return coda.size();
  }

  @Autowired
  private Pqueue coda;
  private static SwabQueue istanza = null;

}
