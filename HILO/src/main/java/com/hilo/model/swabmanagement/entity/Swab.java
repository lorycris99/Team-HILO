package com.hilo.model.swabmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe che modella un tampone per il Covid-19.
 */
@Entity
@Table(name = "tampone")
public class Swab  {
  public Swab() {}

  @Id
  private int id;
  @Column
  private String risultato;
  @Column(name = "isinterno")
  private Boolean isInterno;
  @Column(name = "idstruttura")
  private Integer idStruttura;

  /**
   * Restituisce l'identificativo associato al tampone.
   *
   * @return l'id del tampone
   */
  public int getId() {
    return id;
  }

  /**
   * Permette di impostare un identificativo per il tampone.
   *
   * @param id l'id da impostare per il tampone
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Permette di ottenere il risultato associato al tampone.
   *
   * @return il risultato associato al tampone
   */
  public String getRisultato() {
    return risultato;
  }

  /**
   * Permette di impostare il risultato dell'analisi al tampone.
   *
   * @param risultato il risultato (Positivo, Negativo o Inconcludente)
   */
  public void setRisultato(String risultato) {
    this.risultato = risultato;
  }

  /**
   * Permette di capire se il tampone si riferisce ad un paziente esterno o interno.
   *
   * @return true se interno, false altrimenti
   */
  public Boolean getIsInterno() {
    return isInterno;
  }

  /**
   * Permette di impostare la provenienza del tampone in base alla provenoenza del paziente.
   *
   * @param isInterno true se il paziente e' interno, false se esterno
   */
  public void setIsInterno(Boolean isInterno) {
    this.isInterno = isInterno;
  }

  /**
   * Permette di ottenere la struttura dal quale proviene il tampone.
   *
   * @return l'id della struttra di provenineza
   */
  public Integer getIdStruttura() {
    return idStruttura;
  }

  /**
   * Permette di impostare l'id della struttura di provenienza del tampone.
   *
   * @param idStruttura l'id della struttura di provenienza
   */
  public void setIdStruttura(Integer idStruttura) {
    this.idStruttura = idStruttura;
  }

  @Override
  public String toString() {
    return "Tampone{"
            + "id=" + id
            + ", risultato='"
            + risultato
            + ", isInterno='" + isInterno
            + ", idStruttura='" + idStruttura
            + '}';
  }

}