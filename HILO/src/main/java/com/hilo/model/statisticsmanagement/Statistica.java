package com.hilo.model.statisticsmanagement;

public class Statistica {

  public Statistica() {
  }

  public Statistica(int nPositivi, int nNegativi, int nInconcludenti) {
    this.nPositivi = nPositivi;
    this.nNegativi = nNegativi;
    this.nInconcludenti = nInconcludenti;
  }

  public int getnPositivi() {
    return nPositivi;
  }

  public void setnPositivi(int nPositivi) {
    this.nPositivi = nPositivi;
  }

  public int getnNegativi() {
    return nNegativi;
  }

  public void setnNegativi(int nNegativi) {
    this.nNegativi = nNegativi;
  }

  public int getnInconcludenti() {
    return nInconcludenti;
  }

  public void setnInconcludenti(int nInconcludenti) {
    this.nInconcludenti = nInconcludenti;
  }

  public int getTotali(){
    return nPositivi + nNegativi + nInconcludenti;
  }

  private int nPositivi;
  private int nNegativi;
  private int nInconcludenti;
}
