package com.hilo.model.swabmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "effettua_p")
@IdClass(EmbeddedEffettuaP.class)
public class EffettuaP {
  @Id
  @Column(name = "cfp")
  private String cfP;

  @Id
  @Column(name = "idtampone")
  private Integer idTampone;

  @Column
  private String timestamp;
  
  @Column
  private Double gravity;

  public EffettuaP() {}

  public String getCfP() {
    return cfP;
  }

  public void setCfP(String cfP) {
    this.cfP = cfP;
  }

  public Integer getIdTampone() {
    return idTampone;
  }

  public void setIdTampone(Integer idTampone) {
    this.idTampone = idTampone;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Double getGravity() {
    return gravity;
  }

  public void setGravity(Double gravity) {
    this.gravity = gravity;
  }

  @Override
  public String toString() {
    return "EffettuaP [cfP=" + cfP + ", gravity=" + gravity + ", idTampone=" + idTampone
      + ", timestamp=" + timestamp
      + "]";
  }

  
  
}
