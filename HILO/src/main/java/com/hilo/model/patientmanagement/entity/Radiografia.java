package com.hilo.model.patientmanagement.entity;

import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;

@Entity
@IdClass(EmbeddedRadiografia.class)
public class Radiografia {

  @Id
  private String cfpaziente;

  @Id
  private Integer numero;

  @Lob
  private byte[] img;

  public Radiografia() {
  }

  public String getCfpaziente() {
    return cfpaziente;
  }

  public void setCfpaziente(String cfpaziente) {
    this.cfpaziente = cfpaziente;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public byte[] getImg() {
    return img;
  }

  public void setImg(byte[] img) {
    this.img = img;
  }

  @Override
  public String toString() {
    return "Radiografia{"
            + "cfpaziente='" + cfpaziente + '\''
            + ", numero=" + numero
            + ", img=" + Arrays.toString(img)
            + '}';
  }
}
