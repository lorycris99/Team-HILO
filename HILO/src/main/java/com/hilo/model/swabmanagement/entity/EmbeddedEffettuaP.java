package com.hilo.model.swabmanagement.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedEffettuaP implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "idtampone")
  private Integer idTampone;

  @Column(name = "cfp")
  private String cfP;


  public EmbeddedEffettuaP() {}

  public Integer getIdTampone() {
    return idTampone;
  }

  public void setIdTampone(Integer idTampone) {
    this.idTampone = idTampone;
  }

  public String getCfP() {
    return cfP;
  }

  public void setCfP(String cfP) {
    this.cfP = cfP;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cfP == null) ? 0 : cfP.hashCode());
    result = prime * result + ((idTampone == null) ? 0 : idTampone.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "EmbeddedEffettuaP [cfP=" + cfP + ", idTampone=" + idTampone + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    EmbeddedEffettuaP other = (EmbeddedEffettuaP) obj;
    if (cfP == null) {
      if (other.cfP != null) {
        return false;
      }
    } else if (!cfP.equals(other.cfP)) {
      return false;
    }
    if (idTampone == null) {
      if (other.idTampone != null) {
        return false;
      }
    } else if (!idTampone.equals(other.idTampone)) {
      return false;
    }
    return true;
  }

}
