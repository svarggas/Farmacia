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
public class Ingreso {

    private Integer idIngreso;

    private String fechaIngreso;

    private String fechaSalida;

    private Integer idPaciente;

    private Integer idServicio;

    private String nombrePaciente;

    private String nombreServicio;

    public Ingreso() {

    }

    public Ingreso(String fechaIngreso, String fechaSalida, Integer idPaciente, Integer idServicio) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.idPaciente = idPaciente;
        this.idServicio = idServicio;
    }

    public Integer getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngresos(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idIngreso);
        hash = 29 * hash + Objects.hashCode(this.fechaIngreso);
        hash = 29 * hash + Objects.hashCode(this.fechaSalida);
        hash = 29 * hash + Objects.hashCode(this.idPaciente);
        hash = 29 * hash + Objects.hashCode(this.idServicio);
        hash = 29 * hash + Objects.hashCode(this.nombrePaciente);
        hash = 29 * hash + Objects.hashCode(this.nombreServicio);
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
        final Ingreso other = (Ingreso) obj;
        if (!Objects.equals(this.fechaIngreso, other.fechaIngreso)) {
            return false;
        }
        if (!Objects.equals(this.fechaSalida, other.fechaSalida)) {
            return false;
        }
        if (!Objects.equals(this.nombrePaciente, other.nombrePaciente)) {
            return false;
        }
        if (!Objects.equals(this.nombreServicio, other.nombreServicio)) {
            return false;
        }
        if (!Objects.equals(this.idIngreso, other.idIngreso)) {
            return false;
        }
        if (!Objects.equals(this.idPaciente, other.idPaciente)) {
            return false;
        }
        if (!Objects.equals(this.idServicio, other.idServicio)) {
            return false;
        }
        return true;
    }

    

}
