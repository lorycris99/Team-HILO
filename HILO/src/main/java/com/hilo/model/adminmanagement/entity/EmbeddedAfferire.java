package com.hilo.model.adminmanagement.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;


@Embeddable
public class EmbeddedAfferire implements Serializable {

  private static final long serialVersionUID = 2L;

  private String cfPaziente;
  private Integer idStruttura;

  public EmbeddedAfferire() {
  }

  public String getCfPaziente() {
    return cfPaziente;
  }

  public void setCfPaziente(String cfPaziente) {
    this.cfPaziente = cfPaziente;
  }

  public Integer getIdStruttura() {
    return idStruttura;
  }

  public void setIdStruttura(Integer idStruttura) {
    this.idStruttura = idStruttura;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmbeddedAfferire that = (EmbeddedAfferire) o;
    return Objects.equals(cfPaziente, that.cfPaziente)
            && Objects.equals(idStruttura, that.idStruttura);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cfPaziente, idStruttura);
  }

  @Override
  public String toString() {
    return "EmbeddedAfferire{" + "cfPaziente='" + cfPaziente + '\''
            + ", idStruttura=" + idStruttura + '}';
  }
}
