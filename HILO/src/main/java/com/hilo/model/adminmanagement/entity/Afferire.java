package com.hilo.model.adminmanagement.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name = "afferire")
@IdClass(EmbeddedAfferire.class)
public class Afferire {

  @Id
  @Column(name = "idstruttura")
  int idStruttura;

  @Id
  @Column(name = "cfpaziente")
  String cfPaziente;

  @Column
  int giorni;

  public int getIdstruttura() {
    return idStruttura;
  }

  public void setIdstruttura(int idstruttura) {
    this.idStruttura = idstruttura;
  }

  public String getCfpaziente() {
    return cfPaziente;
  }

  public void setCfpaziente(String cfpaziente) {
    this.cfPaziente = cfpaziente;
  }

  public int getGiorni() {
    return giorni;
  }

  public void setGiorni(int giorni) {
    this.giorni = giorni;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Afferire afferire = (Afferire) o;
    return idStruttura == afferire.idStruttura && giorni == afferire.giorni
        && Objects.equals(cfPaziente, afferire.cfPaziente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idStruttura, cfPaziente, giorni);
  }

  @Override
  public String toString() {
    return "Afferire{" + "idstruttura=" + idStruttura +
      ", cfpaziente='" + cfPaziente + '\'' + ", giorni=" + giorni
        + '}';
  }
}
