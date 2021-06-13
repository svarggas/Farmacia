/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Servicio;
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
@ManagedBean(name = "controllerServicios")
@SessionScoped
public class ControllerServicios implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Servicio> servicios = new ArrayList<>();

    private String nombre;

    private Integer id;

    public ControllerServicios() {

    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.servicios = usu.listarServicios();
    }

    public String agregar() {
        if (nombre == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            usu.crearServicio(this.nombre);
            limpiarVariables();
            listar();
            return "services?faces-redirect=true";
        }
    }

    public String editar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.editarServicio(this.id, this.nombre);
        limpiarVariables();
        listar();
        return "services?faces-redirect=true";
    }

    public String eliminar(Integer id) {
        this.id = id;
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.eliminarServicio(this.id);
        limpiarVariables();
        listar();
        return "services?faces-redirect=true";
    }

    public String redireccionarModificar(Integer idServicio) {
        this.id = idServicio;
        return "servicesModify?faces-redirect=true&idServicio= " + this.id;
    }

    public void limpiarVariables() {
        this.id = null;
        this.nombre = null;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
