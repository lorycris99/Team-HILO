package com.hilo.model.swabmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(EmbeddedEffettuaAs.class)
@Table(name = "effettua_as")
public class EffettuaAs {
  @Id
  @Column(name = "idtampone")
  private Integer idTampone;

  @Id
  @Column(name = "cfas")
  private String cfAs;

  @Column
  private String timestamp;

  public EffettuaAs() {}

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

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "EffettuaAs [cfAs=" + cfAs + ", idTampone=" + idTampone 
      + ", timestamp=" + timestamp + "]";
  }
}
