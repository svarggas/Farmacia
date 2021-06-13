/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.model;

import java.util.Objects;

/**
 *
 * @author josepabloramirez
 */
public class DetalleIngresosRevisionReceta {

    private Integer idIngreso;

    private Integer idRevision;

    private Integer idReceta;

    private String nombrePaciente;

    private String nombreDoctor;

    private String receta;

    private Integer cantidad;

    public DetalleIngresosRevisionReceta() {

    }

    public DetalleIngresosRevisionReceta(Integer idIngreso, Integer idRevision, Integer idReceta) {
        this.idIngreso = idIngreso;
        this.idRevision = idRevision;
        this.idReceta = idReceta;
    }

    public Integer getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Integer getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idIngreso);
        hash = 59 * hash + Objects.hashCode(this.idRevision);
        hash = 59 * hash + Objects.hashCode(this.idReceta);
        hash = 59 * hash + Objects.hashCode(this.nombrePaciente);
        hash = 59 * hash + Objects.hashCode(this.nombreDoctor);
        hash = 59 * hash + Objects.hashCode(this.receta);
        hash = 59 * hash + Objects.hashCode(this.cantidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleIngresosRevisionReceta other = (DetalleIngresosRevisionReceta) obj;
        if (!Objects.equals(this.nombrePaciente, other.nombrePaciente)) {
            return false;
        }
        if (!Objects.equals(this.nombreDoctor, other.nombreDoctor)) {
            return false;
        }
        if (!Objects.equals(this.receta, other.receta)) {
            return false;
        }
        if (!Objects.equals(this.idIngreso, other.idIngreso)) {
            return false;
        }
        if (!Objects.equals(this.idRevision, other.idRevision)) {
            return false;
        }
        if (!Objects.equals(this.idReceta, other.idReceta)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        return true;
    }

}
