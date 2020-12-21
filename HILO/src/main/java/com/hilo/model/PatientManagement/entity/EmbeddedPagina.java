package com.hilo.model.PatientManagement.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedPagina implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cfPaziente;
    private Integer numero;


    public EmbeddedPagina() {}

    public String getCfPaziente() {
        return cfPaziente;
    }

    public void setCfPaziente(String cfPaziente) {
        this.cfPaziente = cfPaziente;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "EmbeddedPagina [cfPaziente=" + cfPaziente + ", numero=" + numero + "]";
    }
    
}
