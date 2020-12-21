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
        EmbeddedPagina other = (EmbeddedPagina) obj;
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
        return "EmbeddedPagina [cfPaziente=" + cfPaziente + ", numero=" + numero + "]";
    }  
}
