package com.hilo.model.swabmanagement.entity;

import java.io.Serializable;
import javax.persistence.Column;

/**
 * Classe che rappresenta la chiave primaria dell'entita' EffettuaAs.
 */
public class EmbeddedEffettuaAs implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Column(name = "idtampone")
  private Integer idTampone;

  @Column(name = "cfas")
  private String cfAs;

  public EmbeddedEffettuaAs() {}

  /**
   * Permette di ottenere l'id del tampone associato.
   *
   * @return l'id del tampone
   */
  public Integer getIdTampone() {
    return idTampone;
  }

  /**
   * Permette di impostare un id al tampone.
   *
   * @param idTampone l'id da impostare
   */
  public void setIdTampone(Integer idTampone) {
    this.idTampone = idTampone;
  }

  /**
   * Permette di ottenere il codice fiscale dell'operatore sanitario.
   *
   * @return il codice fiscale dell'operatore sanitario
   */
  public String getCfAs() {
    return cfAs;
  }

  /**
   * Permette di ottene
   * @param cfAs
   */
  public void setCfAs(String cfAs) {
    this.cfAs = cfAs;
  }

  @Override
  public String toString() {
    return "EmbeddedEffettuaAs [cfAs=" + cfAs + ", idTampone=" + idTampone + "]";
  }
}
