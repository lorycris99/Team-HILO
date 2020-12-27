package com.hilo.model.swabmanagement.entity;

import java.io.Serializable;
import javax.persistence.Column;

public class EmbeddedEffettuaAs implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Column(name = "idtampone")
  private Integer idTampone;

  @Column(name = "cfas")
  private String cfAs;

  public EmbeddedEffettuaAs() {}

  public Integer getIdTampone() {
    return idTampone;
  }

  public void setIdTampone(Integer idTampone) {
    this.idTampone = idTampone;
  }

  public String getCfAs() {
    return cfAs;
  }

  public void setCfAs(String cfAs) {
    this.cfAs = cfAs;
  }

  @Override
  public String toString() {
    return "EmbeddedEffettuaAs [cfAs=" + cfAs + ", idTampone=" + idTampone + "]";
  }
}
