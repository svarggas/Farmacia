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
public class Farmaco {

    private Integer idFarmaco;

    private String nombreComercial;

    private String nombreClinico;

    private String compuestoClinico;

    private String ubicacion;

    private String codigoProveedor;

    public Farmaco() {

    }

    public Farmaco(Integer idFarmaco, String nombreComercial, String nombreClinico, String compuestoClinico, String ubicacion, String codigoProveedor) {
        this.idFarmaco = idFarmaco;
        this.nombreComercial = nombreComercial;
        this.nombreClinico = nombreClinico;
        this.compuestoClinico = compuestoClinico;
        this.ubicacion = ubicacion;
        this.codigoProveedor = codigoProveedor;
    }

    public Integer getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(Integer idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreClinico() {
        return nombreClinico;
    }

    public void setNombreClinico(String nombreClinico) {
        this.nombreClinico = nombreClinico;
    }

    public String getCompuestoClinico() {
        return compuestoClinico;
    }

    public void setCompuestoClinico(String compuestoClinico) {
        this.compuestoClinico = compuestoClinico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idFarmaco);
        hash = 37 * hash + Objects.hashCode(this.nombreComercial);
        hash = 37 * hash + Objects.hashCode(this.nombreClinico);
        hash = 37 * hash + Objects.hashCode(this.compuestoClinico);
        hash = 37 * hash + Objects.hashCode(this.ubicacion);
        hash = 37 * hash + Objects.hashCode(this.codigoProveedor);
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
        final Farmaco other = (Farmaco) obj;
        if (!Objects.equals(this.nombreComercial, other.nombreComercial)) {
            return false;
        }
        if (!Objects.equals(this.nombreClinico, other.nombreClinico)) {
            return false;
        }
        if (!Objects.equals(this.compuestoClinico, other.compuestoClinico)) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.codigoProveedor, other.codigoProveedor)) {
            return false;
        }
        if (!Objects.equals(this.idFarmaco, other.idFarmaco)) {
            return false;
        }
        return true;
    }

}
