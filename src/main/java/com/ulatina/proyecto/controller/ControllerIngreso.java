/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Ingreso;
import com.ulatina.proyecto.model.Paciente;
import com.ulatina.proyecto.model.Servicio;
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
@ManagedBean(name = "controllerIngreso")
@SessionScoped
public class ControllerIngreso implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Ingreso> ingresos = new ArrayList<>();

    private Paciente pacienteSeleccionado = new Paciente();

    private Servicio servicioSeleccionado = new Servicio();

    private Usuario doctorSeleccionado;

    private String fechaIngreso;

    private String fechaSalida;

    private Integer idIngreso;

    public ControllerIngreso() {

    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.ingresos = usu.listarIngresos();
    }

    public String agregar() {
        if (pacienteSeleccionado == null || servicioSeleccionado == null || fechaIngreso == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            usu.crearIngreso(this.pacienteSeleccionado.getIdPaciente(), this.servicioSeleccionado.getIdServicio(), this.fechaIngreso);
            limpiarVariables();
            listar();
            return "admissions.xhtml?faces-redirect=true";
        }
    }

    public String editar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        if (this.fechaSalida == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return null;
        } else {
            usu.editarIngreso(this.idIngreso, this.fechaSalida);
            limpiarVariables();
            listar();
            return "admissions.xhtml?faces-redirect=true";
        }
    }

    public void limpiarVariables() {
        this.doctorSeleccionado = null;
        this.fechaIngreso = null;
        this.fechaSalida = null;
        this.idIngreso = null;
        this.pacienteSeleccionado = null;
        this.servicioSeleccionado = null;
    }

    public String redireccionarModificar(Integer idIngreso) {
        this.idIngreso = idIngreso;
        return "admissionsModify?faces-redirect=true&ingresoId= " + this.idIngreso;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    public Paciente getPacienteSeleccionado() {
        return pacienteSeleccionado;
    }

    public void setPacienteSeleccionado(Paciente pacienteSeleccionado) {
        this.pacienteSeleccionado = pacienteSeleccionado;
    }

    public Servicio getServicioSeleccionado() {
        return servicioSeleccionado;
    }

    public void setServicioSeleccionado(Servicio servicioSeleccionado) {
        this.servicioSeleccionado = servicioSeleccionado;
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

    public Integer getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Usuario getDoctorSeleccionado() {
        return doctorSeleccionado;
    }

    public void setDoctorSeleccionado(Usuario doctorSeleccionado) {
        this.doctorSeleccionado = doctorSeleccionado;
    }

}
