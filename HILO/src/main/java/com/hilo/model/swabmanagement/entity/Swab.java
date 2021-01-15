package com.hilo.model.swabmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tampone")
public class Swab implements Comparable {
  public Swab() {}

  @Id
  private int id;
  @Column
  private String risultato;
  @Column(name = "isinterno")
  private Boolean isInterno;
  @Column(name = "idstruttura")
  private Integer idStruttura;

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

  public Integer getIdStruttura() {
    return idStruttura;
  }

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

  @Override
  /**
   * Metodo necessario in quanto la classe implemtenta comparable
   * ma dal momento che esegue tutto la classe SwabComparator il
   * metodo non serve
   */
  public int compareTo(Object o) {
    return 0;
  }
}