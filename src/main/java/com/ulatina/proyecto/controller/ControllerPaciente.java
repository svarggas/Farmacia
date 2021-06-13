/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Paciente;
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
@ManagedBean(name = "controllerPaciente")
@SessionScoped
public class ControllerPaciente implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Paciente> pacientes = new ArrayList<>();

    private String nombre;

    private Integer idSeguroSocial;

    private String direccion;

    private String telefono;

    private String fechaNacimiento;

    private Integer idPaciente;

    public ControllerPaciente() {

    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.pacientes = usu.listarPaciente();
    }

    public String agregar() {
        if (nombre == null || idSeguroSocial == null || direccion == null
                || telefono == null || fechaNacimiento == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            usu.crearPaciente(this.nombre, this.idSeguroSocial, this.direccion, this.telefono, this.fechaNacimiento);
            limpiarVariables();
            listar();
            return "patients?faces-redirect=true";
        }
    }

    public String editar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.editarPaciente(this.idPaciente, this.nombre, this.idSeguroSocial, this.direccion, this.telefono);
        limpiarVariables();
        listar();
        return "patients?faces-redirect=true";
    }

    public String redireccionarModificar(Integer idPaciente, String nombre, Integer idSeguroSocial, String direccion, String telefono) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.idSeguroSocial = idSeguroSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        return "patientsModify?faces-redirect=true&idPaciente= " + this.idPaciente;
    }

    public void limpiarVariables() {
        this.nombre = null;
        this.idSeguroSocial = null;
        this.direccion = null;
        this.telefono = null;
        this.fechaNacimiento = null;
        this.idPaciente = null;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdSeguroSocial() {
        return idSeguroSocial;
    }

    public void setIdSeguroSocial(Integer idSeguroSocial) {
        this.idSeguroSocial = idSeguroSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

}
