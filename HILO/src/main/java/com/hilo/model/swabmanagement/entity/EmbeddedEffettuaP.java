package com.hilo.model.swabmanagement.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe che rappresenta la chiave primaria dell'entita' EffettuaP.
 */
@Embeddable
public class EmbeddedEffettuaP implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "idtampone")
  private Integer idTampone;

  @Column(name = "cfp")
  private String cfP;


  public EmbeddedEffettuaP() {}

  /**
   * Permette di ottenere l'id del tampone.
   *
   * @return l'id del tampone
   */
  public Integer getIdTampone() {
    return idTampone;
  }

  /**
   * Permette di settare l'id del tampone.
   *
   * @param idTampone l'id del tampone da impostare
   */
  public void setIdTampone(Integer idTampone) {
    this.idTampone = idTampone;
  }

  /**
   * Permette di ottenere il codice fiscale associato.
   *
   * @return il codice fiscale
   */
  public String getCfP() {
    return cfP;
  }

  /**
   * Permette di impostare il codice fiscale.
   *
   * @param cfP il codice fiscale da impostare
   */
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
