package com.hilo.model.HealthWorkerManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="agente_sanitario")
public class HealthWorker {
    @Id
    private String cf;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String mail;
    @Column
    private String telefono;
    @Column
    private String ruolo;
    @Column
    private String cognome;
    @Column
    private String nome;
    @Column
    private String indirizzo;
    @Column
    private int idstruttura;

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
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

    public int getIdstruttura() {
        return idstruttura;
    }

    public void setIdstruttura(int idstruttura) {
        this.idstruttura = idstruttura;
    }

    public HealthWorker() {
    }

    @Override
    public String toString() {
        return "HealthWorker{" +
                "cf='" + cf + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ruolo='" + ruolo + '\'' +
                ", cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", idstruttura=" + idstruttura +
                '}';
    }
}
