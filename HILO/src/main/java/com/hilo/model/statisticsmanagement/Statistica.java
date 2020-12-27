package com.hilo.model.statisticsmanagement;

import java.io.Serializable;

public class Statistica implements Serializable {

  public Statistica() {
  }

  public Statistica(int numPositivi, int numNegativi, int numInconcludenti) {
    this.numPositivi = numPositivi;
    this.numNegativi = numNegativi;
    this.numInconcludenti = numInconcludenti;
  }

  public int getnPositivi() {
    return numPositivi;
  }

  public void setnPositivi(int numPositivi) {
    this.numPositivi = numPositivi;
  }

  public int getnumNegativi() {
    return numNegativi;
  }

  public void setnNegativi(int numNegativi) {
    this.numNegativi = numNegativi;
  }

  public int getnInconcludenti() {
    return numInconcludenti;
  }

  public void setnInconcludenti(int numInconcludenti) {
    this.numInconcludenti = numInconcludenti;
  }

  public int getTotali() {
    return numPositivi + numNegativi + numInconcludenti;
  }

  private int numPositivi;
  private int numNegativi;
  private int numInconcludenti;
  private static final long serialVersionUID = 100L;
}