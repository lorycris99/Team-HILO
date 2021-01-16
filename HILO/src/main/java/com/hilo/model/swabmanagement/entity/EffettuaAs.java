package com.hilo.model.swabmanagement.entity;

import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EffettuaAs that = (EffettuaAs) o;
    return Objects.equals(idTampone, that.idTampone)
            && Objects.equals(cfAs, that.cfAs)
            && Objects.equals(timestamp, that.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTampone, cfAs, timestamp);
  }
}
