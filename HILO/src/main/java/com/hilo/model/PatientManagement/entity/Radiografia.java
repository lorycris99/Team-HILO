package com.hilo.model.PatientManagement.entity;

import javax.persistence.*;

@Entity
@IdClass(EmbeddedRadiografia.class)
public class Radiografia {

    @Id
    private String cfpaziente;

    @Id
    private Integer numero;

    @Lob
    private Byte[] img;

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

    public Byte[] getImg() {
        return img;
    }

    public void setImg(Byte[] img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Radiografia{" +
                "cfpaziente='" + "er.getCfpaziente()" + '\'' +
                ", numero=" + "er.getNumero()" +
                ", img=" + img +
                '}';
    }
}
