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
  @Column
  int idstruttura;

  @Id
  @Column
  String cfpaziente;

  @Column
  int giorni;

  public int getIdstruttura() {
    return idstruttura;
  }

  public void setIdstruttura(int idstruttura) {
    this.idstruttura = idstruttura;
  }

  public String getCfpaziente() {
    return cfpaziente;
  }

  public void setCfpaziente(String cfpaziente) {
    this.cfpaziente = cfpaziente;
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
    return idstruttura == afferire.idstruttura && giorni == afferire.giorni
            && Objects.equals(cfpaziente, afferire.cfpaziente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idstruttura, cfpaziente, giorni);
  }

  @Override
  public String toString() {
    return "Afferire{" + "idstruttura=" + idstruttura + ", cfpaziente='"
            + cfpaziente + '\'' + ", giorni=" + giorni + '}';
  }
}
