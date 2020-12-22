package com.hilo.model.patientmanagement.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedPaginaDiarioClinico implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public EmbeddedPaginaDiarioClinico() {}

    private Integer numero;
    private String cfPaziente;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCfPaziente() {
        return cfPaziente;
    }

    public void setCfPaziente(String cfPaziente) {
        this.cfPaziente = cfPaziente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cfPaziente == null) ? 0 : cfPaziente.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmbeddedPaginaDiarioClinico other = (EmbeddedPaginaDiarioClinico) obj;
        if (cfPaziente == null) {
            if (other.cfPaziente != null)
                return false;
        } else if (!cfPaziente.equals(other.cfPaziente))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EmbeddedPaginaDiarioClinico [cfPaziente=" + cfPaziente + ", numero=" + numero + "]";
    }
}