/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Farmaco;
import com.ulatina.proyecto.service.ControlProcAlmac;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author kenneth
 */
@ManagedBean(name = "controllerFarmaco")
@SessionScoped
public class ControllerFarmaco implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Farmaco> farmacos = new ArrayList<>();

    private String nombreComercial;

    private String nombreClinico;

    private String compuestoQuimico;

    private String ubicacion;

    private String codigoProveedor;

    private Integer idRegistro;

    public ControllerFarmaco() {

    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.farmacos = usu.listarFarmaco();
    }

    public String agregar() {
        if (nombreComercial == null || nombreClinico == null || compuestoQuimico == null
                || ubicacion == null || codigoProveedor == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            usu.crearFarmaco(this.nombreComercial, this.nombreClinico, this.compuestoQuimico, this.ubicacion, this.codigoProveedor);
            limpiarVariables();
            listar();
            return "drugs.xhtml?faces-redirect=true";
        }
    }

    public String editar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.editarFarmaco(this.idRegistro, this.nombreComercial, this.nombreClinico, this.compuestoQuimico, this.ubicacion, this.codigoProveedor);
        limpiarVariables();
        listar();
        return "drugs.xhtml?faces-redirect=true";
    }

    public String eliminar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.eliminarFarmaco(this.idRegistro);
        limpiarVariables();
        listar();
        return "drugs.xhtml?faces-redirect=true";
    }

    public void limpiarVariables() {
        this.idRegistro = null;
        this.nombreClinico = null;
        this.nombreComercial = null;
        this.compuestoQuimico = null;
        this.ubicacion = null;
        this.codigoProveedor = null;
    }

    public List<Farmaco> getFarmacos() {
        return farmacos;
    }

    public void setFarmacos(List<Farmaco> farmacos) {
        this.farmacos = farmacos;
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

    public String getCompuestoQuimico() {
        return compuestoQuimico;
    }

    public void setCompuestoQuimico(String compuestoQuimico) {
        this.compuestoQuimico = compuestoQuimico;
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

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

}
