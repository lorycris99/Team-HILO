package com.hilo.model.swabmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tampone")
public class Swab {
  public Swab() {}

  @Id
  private int id;
  @Column
  private String risultato;
  @Column
  private Boolean isInterno;
  @Column
  private String idStruttura;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRisultato() {
    return risultato;
  }

  public void setRisultato(String risultato) {
    this.risultato = risultato;
  }

  public Boolean getIsInterno() {
    return isInterno;
  }

  public void setIsInterno(Boolean isInterno) {
    this.isInterno = isInterno;
  }

  public String getIdStruttura() {
    return idStruttura;
  }

  public void setIdStruttura(String idStruttura) {
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