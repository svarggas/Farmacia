/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.DetalleIngresosRevisionReceta;
import com.ulatina.proyecto.model.Ingreso;
import com.ulatina.proyecto.model.Receta;
import com.ulatina.proyecto.model.Revision;
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
@ManagedBean(name = "controllerDetalleIngresoRevisionReceta")
@SessionScoped
public class ControllerDetalleIngresoRevisionReceta implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<DetalleIngresosRevisionReceta> detalles = new ArrayList<>();

    private Ingreso ingresoSeleccionado;

    private Revision revisionSeleccionado;

    private Receta recetaSeleccionado;

    private int id;

    public ControllerDetalleIngresoRevisionReceta() {

    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.detalles = usu.listarDetalleIngresosRevisionRecetas();
    }

    public String agregar() {
        if (ingresoSeleccionado == null || revisionSeleccionado == null || recetaSeleccionado == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            usu.crearRevisionReceta(this.ingresoSeleccionado.getIdIngreso(), this.revisionSeleccionado.getIdRevision(), this.recetaSeleccionado.getIdReceta());
            limpiarVariables();
            listar();
            return "userProfile.xhtml?faces-redirect=true";
        }
    }

    public void limpiarVariables() {
        this.ingresoSeleccionado = null;
        this.recetaSeleccionado = null;
        this.revisionSeleccionado = null;
    }

    public List<DetalleIngresosRevisionReceta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleIngresosRevisionReceta> detalles) {
        this.detalles = detalles;
    }

    public Ingreso getIngresoSeleccionado() {
        return ingresoSeleccionado;
    }

    public void setIngresoSeleccionado(Ingreso ingresoSeleccionado) {
        this.ingresoSeleccionado = ingresoSeleccionado;
    }

    public Revision getRevisionSeleccionado() {
        return revisionSeleccionado;
    }

    public void setRevisionSeleccionado(Revision revisionSeleccionado) {
        this.revisionSeleccionado = revisionSeleccionado;
    }

    public Receta getRecetaSeleccionado() {
        return recetaSeleccionado;
    }

    public void setRecetaSeleccionado(Receta recetaSeleccionado) {
        this.recetaSeleccionado = recetaSeleccionado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
