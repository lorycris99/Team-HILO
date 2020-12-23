package com.hilo.model.adminmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "struttura")
public class Struttura {
  @Id
  int id;
  @Column
  Boolean isanalisis;
  @Column
  String regione;
  @Column
  String nome;
  @Column
  String indirizzo;
}
