package com.hilo.patient.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paziente")
public class Patient {
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

    @Column(name="isinterno")
    private Boolean isInterno;

    @Column
    private String indirizzo;

    @Column
    private String nome;

    @Column
    private String cognome;

    public Patient() {

    }

    public Patient(String cf, String username, String password, String mail, String telefono, Boolean isInterno, String indirizzo, String nome, String cognome) {
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.telefono = telefono;
        this.isInterno = isInterno;
        this.indirizzo = indirizzo;
        this.nome = nome;
        this.cognome = cognome;
    }

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

    public Boolean getIsInterno() {
        return isInterno;
    }

    public void setIsInterno(Boolean interno) {
        isInterno = interno;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "cf='" + cf + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                ", isInterno=" + isInterno +
                ", indirizzo='" + indirizzo + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
