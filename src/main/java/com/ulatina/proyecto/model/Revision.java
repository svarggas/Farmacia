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
public class Revision {

    private Integer idRevision;

    private Integer idDoctor;

    private String nombreDoctor;

    private Integer idIngreso;

    private String nombrePaciente;

    private String fechaRevision;

    private String informe;

    public Revision() {

    }

    public Revision(Integer id, Integer idDoctor, String nombreDoctor, Integer idIngreso, String nombrePaciente, String fechaRevision, String informe) {
        this.idRevision = id;
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.idIngreso = idIngreso;
        this.nombrePaciente = nombrePaciente;
        this.fechaRevision = fechaRevision;
        this.informe = informe;
    }

    public Integer getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idRevision);
        hash = 37 * hash + Objects.hashCode(this.idDoctor);
        hash = 37 * hash + Objects.hashCode(this.nombreDoctor);
        hash = 37 * hash + Objects.hashCode(this.idIngreso);
        hash = 37 * hash + Objects.hashCode(this.nombrePaciente);
        hash = 37 * hash + Objects.hashCode(this.fechaRevision);
        hash = 37 * hash + Objects.hashCode(this.informe);
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
        final Revision other = (Revision) obj;
        if (!Objects.equals(this.nombreDoctor, other.nombreDoctor)) {
            return false;
        }
        if (!Objects.equals(this.nombrePaciente, other.nombrePaciente)) {
            return false;
        }
        if (!Objects.equals(this.fechaRevision, other.fechaRevision)) {
            return false;
        }
        if (!Objects.equals(this.informe, other.informe)) {
            return false;
        }
        if (!Objects.equals(this.idRevision, other.idRevision)) {
            return false;
        }
        if (!Objects.equals(this.idDoctor, other.idDoctor)) {
            return false;
        }
        if (!Objects.equals(this.idIngreso, other.idIngreso)) {
            return false;
        }
        return true;
    }

}
