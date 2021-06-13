/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.controller;

import com.ulatina.proyecto.model.Servicio;
import com.ulatina.proyecto.service.ControlProcAlmac;
import com.ulatina.proyecto.model.Usuario;
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
@ManagedBean(name = "controllerUsuario")
@SessionScoped
public class ControllerUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuario;

    private String usuario;

    private String contrasena;

    private Servicio servicio;

    private String nombre;

    private String direccion;

    private String telefono;

    private String tipoUsuario;

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    private Usuario usuarioConect;

    private List<Usuario> doctores = new ArrayList<Usuario>();

    private String nombreServicio;

    public ControllerUsuario() {

    }

    @PostConstruct
    public void init() {
        listar();
        listarDoctores();
    }

    public void listar() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.usuarios = usu.listarUsuarios();
    }

    public String eliminarUsuario(Integer id) {
        this.idUsuario = id;
        System.out.println(this.idUsuario);
        ControlProcAlmac usu = new ControlProcAlmac();
        usu.eliminarUsuario(this.idUsuario);
        limpiarVariables();
        listar();
        return "users?faces-redirect=true";
    }

    public String editar_usuario() {
        ControlProcAlmac usu = new ControlProcAlmac();
        System.out.println(this.tipoUsuario);
        if (this.tipoUsuario.equals("doctor")) {
            System.out.println("soy doctor");
            System.out.println(this.servicio.getIdServicio());
            usu.agregarServicioDoctor(this.idUsuario, this.servicio.getIdServicio());
            limpiarVariables();
            listar();
            return "users?faces-redirect=true";
        }
        if (this.usuarioConect.getIdUsuario() != this.idUsuario) {
            System.out.println("modificando usuario en la lista");
            System.out.println(this.idUsuario);
            usu.editarUsuario(this.idUsuario, this.nombre, this.direccion, this.telefono);
            limpiarVariables();
            listar();
            return "users?faces-redirect=true";
        } else {
            usu.editarUsuario(this.usuarioConect.getIdUsuario(), this.nombre, this.direccion, this.telefono);
            limpiarVariables();
            listar();
            return "users?faces-redirect=true";
        }
    }

    public String crear_usuario() {
        if (nombre == null || usuario == null || contrasena == null || direccion == null || telefono == null || tipoUsuario == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error!", "Please enter all required spaces."));
            return "error.xhtml?faces-redirect=true";
        } else {
            ControlProcAlmac usu = new ControlProcAlmac();
            if (this.servicio == null) {
                usu.crearUsuario(this.nombre, this.usuario, this.contrasena, this.direccion, this.telefono, this.tipoUsuario, 0);
            } else {
                usu.crearUsuario(this.nombre, this.usuario, this.contrasena, this.direccion, this.telefono, this.tipoUsuario, this.servicio.getIdServicio());
            }
            limpiarVariables();
            listar();
            return "users?faces-redirect=true";
        }
    }

    public String login() {
        FacesMessage msg = null;
        ControlProcAlmac usu = new ControlProcAlmac();
        this.usuarioConect = usu.login(this.usuario, this.contrasena);
        if (this.usuarioConect != null) {
            this.nombre = this.usuarioConect.getNombre();
            this.direccion = this.usuarioConect.getDireccion();
            this.telefono = this.usuarioConect.getTelefono();
            System.out.println(this.usuarioConect.getIdUsuario());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuarioConect.getNombre());
            return "userProfile?faces-redirect=true";
        } else {
            return "error?faces-redirect=true";
        }
    }

    public String logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .invalidateSession();
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String redireccionarModificar(Integer idUsuario, String nombre, String direccion, String telefono, String tipo, String servicio) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoUsuario = tipo;
        this.nombreServicio = servicio;
        return "usersModify?faces-redirect=true&idUsuario= " + this.idUsuario;
    }

    public String redireccionarCrearUsuario() {
        this.nombre = null;
        this.contrasena = null;
        this.usuario = null;
        this.telefono = null;
        this.direccion = null;
        return "usersAdd?faces-redirect=true";
    }

    public void limpiarVariables() {
        this.nombre = null;
        this.contrasena = null;
        this.usuario = null;
        this.telefono = null;
        this.direccion = null;
    }

    public void listarDoctores() {
        ControlProcAlmac usu = new ControlProcAlmac();
        this.doctores = usu.listarDoctores();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuarioConect() {
        return usuarioConect;
    }

    public void setUsuarioConect(Usuario usuarioConect) {
        this.usuarioConect = usuarioConect;
    }

    public List<Usuario> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Usuario> doctores) {
        this.doctores = doctores;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

}
