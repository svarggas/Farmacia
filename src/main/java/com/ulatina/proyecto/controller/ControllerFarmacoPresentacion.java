/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Farmaco;
import com.ulatina.proyecto.model.FarmacoPresentacion;
import com.ulatina.proyecto.model.Presentacion;
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
@ManagedBean(name = "controllerFarmacoPresentacion")
@SessionScoped
public class ControllerFarmacoPresentacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<FarmacoPresentacion> farmacosPresentaciones = new ArrayList<>();

    private Farmaco farmacoSeleccionado;

    private Presentacion presentacionSeleccionada;

    private Integer monto;

    private Integer idFarmacoPresentacion;

    private Integer idFarmaco;

    private Integer idPresentacion;

    private String dscFarmaco;

    private String dscPresentacion;

    public ControllerFarmacoPresentacion() {

    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.farmacosPresentaciones = usu.listarFarmacoPresentacion();
    }

    public String agregar() {
        if (farmacoSeleccionado.getIdFarmaco() == null
                || presentacionSeleccionada.getIdPresentacion() == null
                || monto == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            usu.crearFarmacoPresentacion(this.farmacoSeleccionado.getIdFarmaco(), this.presentacionSeleccionada.getIdPresentacion(), this.monto);
            limpiarVariables();
            listar();
            return "drugs.xhtml?faces-redirect=true";
        }
    }

    public String editar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.editarFarmacoPresentacion(this.idFarmaco, this.idPresentacion, this.monto);
        limpiarVariables();
        listar();
        return "drugs.xhtml?faces-redirect=true";
    }

    public String eliminar(Integer idFarmaco, Integer idPresentacion) {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.eliminarFarmacoPresentacion(idFarmaco, idPresentacion);
        limpiarVariables();
        listar();
        return "drugs.xhtml?faces-redirect=true";
    }

    public String redireccionarModificar(Integer idFarmaco, Integer idPresentacion, String farmaco, String presentacion) {
        this.idFarmaco = idFarmaco;
        this.idPresentacion = idPresentacion;
        this.dscFarmaco = farmaco;
        this.dscPresentacion = presentacion;
        return "drugsModify?faces-redirect=true&idFarmaco= " + this.idFarmaco + "&idPresentacion= " + this.idPresentacion;
    }

    public void limpiarVariables() {
        this.dscFarmaco = null;
        this.dscPresentacion = null;
        this.farmacoSeleccionado = null;
        this.idFarmaco = null;
        this.idFarmacoPresentacion = null;
        this.idPresentacion = null;
        this.monto = null;
        this.presentacionSeleccionada = null;
    }

    public List<FarmacoPresentacion> getFarmacosPresentaciones() {
        return farmacosPresentaciones;
    }

    public void setFarmacosPresentaciones(List<FarmacoPresentacion> farmacosPresentaciones) {
        this.farmacosPresentaciones = farmacosPresentaciones;
    }

    public Farmaco getFarmacoSeleccionado() {
        return farmacoSeleccionado;
    }

    public void setFarmacoSeleccionado(Farmaco farmacoSeleccionado) {
        this.farmacoSeleccionado = farmacoSeleccionado;
    }

    public Presentacion getPresentacionSeleccionada() {
        return presentacionSeleccionada;
    }

    public void setPresentacionSeleccionada(Presentacion presentacionSeleccionada) {
        this.presentacionSeleccionada = presentacionSeleccionada;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getId() {
        return idFarmacoPresentacion;
    }

    public void setId(Integer idFarmacoPresentacion) {
        this.idFarmacoPresentacion = idFarmacoPresentacion;
    }

    public Integer getIdFarmacoPresentacion() {
        return idFarmacoPresentacion;
    }

    public void setIdFarmacoPresentacion(Integer idFarmacoPresentacion) {
        this.idFarmacoPresentacion = idFarmacoPresentacion;
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

    public String getDscFarmaco() {
        return dscFarmaco;
    }

    public void setDscFarmaco(String dscFarmaco) {
        this.dscFarmaco = dscFarmaco;
    }

    public String getDscPresentacion() {
        return dscPresentacion;
    }

    public void setDscPresentacion(String dscPresentacion) {
        this.dscPresentacion = dscPresentacion;
    }

}
