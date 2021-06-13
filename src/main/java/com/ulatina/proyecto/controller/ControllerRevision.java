/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Ingreso;
import com.ulatina.proyecto.model.Revision;
import com.ulatina.proyecto.model.Usuario;
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
@ManagedBean(name = "controllerRevision")
@SessionScoped
public class ControllerRevision implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Revision> revisiones = new ArrayList<Revision>();

    private Integer idRevision;

    private String fechaRevision;

    private String informe;

    private Usuario selectedDoctor = new Usuario();

    private Ingreso selectedIngreso = new Ingreso();

    public ControllerRevision() {

    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.revisiones = usu.listarRevisiones();
    }

    public String agregar() {
        System.out.println("AQUI ESTOUDDJAJKKJAHDFJKAHDK");
        if (selectedDoctor == null || selectedIngreso == null || fechaRevision == null || informe == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            usu.crearRevision(this.selectedDoctor.getIdUsuario(), this.selectedIngreso.getIdIngreso(), this.fechaRevision, this.informe);
            limpiarVariables();
            listar();
            return "revisions?faces-redirect=true";
        }
    }

    public String add() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.crearRevision(this.selectedDoctor.getIdUsuario(), this.selectedIngreso.getIdIngreso(), this.fechaRevision, this.informe);
        limpiarVariables();
        listar();
        return "revisions?faces-redirect=true";
    }

    public String editar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.editarRevision(this.idRevision, this.informe);
        limpiarVariables();
        listar();
        return "revisions?faces-redirect=true";
    }

    public String redireccionarModificar(Integer idRevision) {
        this.idRevision = idRevision;
        return "revisionsModify?faces-redirect=true&idRevision= " + this.idRevision;
    }

    public void limpiarVariables() {
        this.selectedDoctor = null;
        this.selectedIngreso = null;
        this.fechaRevision = null;
        this.informe = null;
        this.idRevision = null;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
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

    public Usuario getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(Usuario selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    public Ingreso getSelectedIngreso() {
        return selectedIngreso;
    }

    public void setSelectedIngreso(Ingreso selectedIngreso) {
        this.selectedIngreso = selectedIngreso;
    }

}
