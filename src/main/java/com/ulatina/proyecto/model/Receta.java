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
public class Receta {

    private Integer idReceta;

    private String fechaReceta;

    private Integer cantidad;

    private Integer idFarmaco;

    private Integer idPresentacion;

    private Integer idDoctor;

    private String medicamento;

    private String presentacionFarmaco;

    private String nombreDoctor;

    public Receta() {

    }

    public Receta(String fechaReceta, Integer cantidad, Integer idFarmaco, Integer idPresentacion, Integer idDoctor) {
        this.fechaReceta = fechaReceta;
        this.cantidad = cantidad;
        this.idFarmaco = idFarmaco;
        this.idPresentacion = idPresentacion;
        this.idDoctor = idDoctor;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getFechaReceta() {
        return fechaReceta;
    }

    public void setFechaReceta(String fechaReceta) {
        this.fechaReceta = fechaReceta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(Integer idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getPresentacionFarmaco() {
        return presentacionFarmaco;
    }

    public void setPresentacionFarmaco(String presentacionFarmaco) {
        this.presentacionFarmaco = presentacionFarmaco;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.idReceta);
        hash = 13 * hash + Objects.hashCode(this.fechaReceta);
        hash = 13 * hash + Objects.hashCode(this.cantidad);
        hash = 13 * hash + Objects.hashCode(this.idFarmaco);
        hash = 13 * hash + Objects.hashCode(this.idPresentacion);
        hash = 13 * hash + Objects.hashCode(this.idDoctor);
        hash = 13 * hash + Objects.hashCode(this.medicamento);
        hash = 13 * hash + Objects.hashCode(this.presentacionFarmaco);
        hash = 13 * hash + Objects.hashCode(this.nombreDoctor);
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
        final Receta other = (Receta) obj;
        if (!Objects.equals(this.fechaReceta, other.fechaReceta)) {
            return false;
        }
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        if (!Objects.equals(this.presentacionFarmaco, other.presentacionFarmaco)) {
            return false;
        }
        if (!Objects.equals(this.nombreDoctor, other.nombreDoctor)) {
            return false;
        }
        if (!Objects.equals(this.idReceta, other.idReceta)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.idFarmaco, other.idFarmaco)) {
            return false;
        }
        if (!Objects.equals(this.idPresentacion, other.idPresentacion)) {
            return false;
        }
        if (!Objects.equals(this.idDoctor, other.idDoctor)) {
            return false;
        }
        return true;
    }

}
