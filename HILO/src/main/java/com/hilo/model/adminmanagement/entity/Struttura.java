package com.hilo.model.adminmanagement.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "struttura")
public class Struttura {
  @Id
  private int id;
  @Column
  private Boolean isanalisis;
  @Column
  private String regione;
  @Column
  private String nome;
  @Column
  private String indirizzo;

  public Struttura() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Boolean getIsanalisis() {
    return isanalisis;
  }

  public void setIsanalisis(Boolean isanalisis) {
    this.isanalisis = isanalisis;
  }

  public String getRegione() {
    return regione;
  }

  public void setRegione(String regione) {
    this.regione = regione;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { 
      return true; 
    }
    if (o == null || getClass() != o.getClass()) { 
      return false; 
    }
    Struttura struttura = (Struttura) o;
    return id == struttura.id
            && Objects.equals(isanalisis, struttura.isanalisis)
            && Objects.equals(regione, struttura.regione)
            && Objects.equals(nome, struttura.nome)
            && Objects.equals(indirizzo, struttura.indirizzo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isanalisis, regione, nome, indirizzo);
  }

  @Override
  public String toString() {
    return "Struttura{"
            + "id=" + id
            + ", isanalisis=" + isanalisis
            + ", regione='" + regione + '\''
            + ", nome='" + nome + '\''
            + ", indirizzo='" + indirizzo + '\''
            + '}';
  }
}
