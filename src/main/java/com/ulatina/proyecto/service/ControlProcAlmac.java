/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.service;

import com.ulatina.proyecto.model.DetalleIngresosRevisionReceta;
import com.ulatina.proyecto.model.Farmaco;
import com.ulatina.proyecto.model.FarmacoPresentacion;
import com.ulatina.proyecto.model.Ingreso;
import com.ulatina.proyecto.model.Paciente;
import com.ulatina.proyecto.model.Presentacion;
import com.ulatina.proyecto.model.Receta;
import com.ulatina.proyecto.model.Revision;
import com.ulatina.proyecto.model.Servicio;
import com.ulatina.proyecto.model.Usuario;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenne
 */
public class ControlProcAlmac implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Conector conectorJDBC = Conector.getConector();

    private final static String SP_LISTAR_USUARIOS = "{ CALL ProyectoTresDemo.listar_usuario() }";
    private final static String SP_LISTAR_SERVICIOS = "{ CALL ProyectoTresDemo.listar_servicios() }";
    private final static String SP_LISTAR_REVISIONES = "{ CALL ProyectoTresDemo.listar_revision() }";
    private final static String SP_LISTAR_RECETAS = "{ CALL ProyectoTresDemo.listar_recetas() }";
    private final static String SP_LISTAR_PRESENTACION = "{ CALL ProyectoTresDemo.listar_presentacion() }";
    private final static String SP_LISTAR_PACIENTES = "{ CALL ProyectoTresDemo.listar_pacientes() }";
    private final static String SP_LISTAR_INGRESOS = "{ CALL ProyectoTresDemo.listar_ingresos() }";
    private final static String SP_LISTAR_FARMACOS = "{ CALL ProyectoTresDemo.listar_farmacos() }";
    private final static String SP_LISTAR_FARMACO_PRESENTACION = "{ CALL ProyectoTresDemo.listar_farmaco_presentacion() }";
    private final static String SP_LISTAR_DETALLE_INGRESO_REVISION_RECETA = "{ CALL ProyectoTresDemo.listar_detalle_ingreso_revision_receta() }";
    private final static String SP_CREAR_USUARIO = "{ CALL ProyectoTresDemo.crear_usuario(?,?,?,?,?,?,?) }";
    private final static String SP_CREAR_SERVICIO = "{ CALL ProyectoTresDemo.crear_servicio(?) }";
    private final static String SP_CREAR_REVISION_RECETA = "{ CALL ProyectoTresDemo.crear_revision_receta(?,?,?) }";
    private final static String SP_CREAR_REVISION = "{ CALL ProyectoTresDemo.crear_revision(?,?,?,?) }";
    private final static String SP_CREAR_RECETA = "{ CALL ProyectoTresDemo.crear_receta(?,?,?,?,?) }";
    private final static String SP_CREAR_PRESENTACION = "{ CALL ProyectoTresDemo.crear_presentacion(?) }";
    private final static String SP_CREAR_PACIENTE = "{ CALL ProyectoTresDemo.crear_paciente(?,?,?,?,?) }";
    private final static String SP_CREAR_INGRESO = "{ CALL ProyectoTresDemo.crear_ingreso(?,?,?) }";
    private final static String SP_CREAR_FARMACO_PRESENTACION = "{ CALL ProyectoTresDemo.crear_farmaco_presentacion(?,?,?) }";
    private final static String SP_CREAR_FARMACO = "{ CALL ProyectoTresDemo.crear_farmaco(?,?,?,?,?) }";
    private final static String SP_EDITAR_USUARIO = "{ CALL ProyectoTresDemo.editar_usuario(?,?,?,?) }";
    private final static String SP_EDITAR_SERVICIO = "{ CALL ProyectoTresDemo.editar_servicio(?,?) }";
    private final static String SP_EDITAR_REVISION = "{ CALL ProyectoTresDemo.editar_revisiones(?,?) }";
    private final static String SP_EDITAR_RECETA = "{ CALL ProyectoTresDemo.editar_receta(?,?) }";
    private final static String SP_EDITAR_PRESENTACION = "{ CALL ProyectoTresDemo.editar_presentacion(?,?) }";
    private final static String SP_EDITAR_PACIENTE = "{ CALL ProyectoTresDemo.editar_paciente(?,?,?,?,?) }";
    private final static String SP_EDITAR_INGRESO = "{ CALL ProyectoTresDemo.editar_ingreso(?,?) }";
    private final static String SP_EDITAR_FARMACO_PRESENTACION = "{ CALL ProyectoTresDemo.editar_farmaco_presentacion(?,?,?) }";
    private final static String SP_EDITAR_FARMACO = "{ CALL ProyectoTresDemo.editar_farmaco(?,?,?,?,?,?) }";
    private final static String SP_ELIMINAR_USUARIO = "{ CALL ProyectoTresDemo.eliminar_usuario(?) }";
    private final static String SP_ELIMINAR_SERVICIO = "{ CALL ProyectoTresDemo.eliminar_servicio(?) }";
    private final static String SP_ELIMINAR_PRESENTACION = "{ CALL ProyectoTresDemo.eliminar_presentacion(?) }";
    private final static String SP_ELIMINAR_FARMACO_PRESENTACION = "{ CALL ProyectoTresDemo.eliminar_farmaco_presentacion(?,?) }";
    private final static String SP_ELIMINAR_FARMACO = "{ CALL ProyectoTresDemo.eliminar_farmaco(?) }";
    private final static String SP_LOGIN = "{ CALL ProyectoTresDemo.login(?,?) }";
    private final static String SP_FIND_BY_PK_PACIENTE = "{ CALL ProyectoTresDemo.pacienteFindByPK(?) }";
    private final static String SP_FIND_BY_PK_USUARIO = "{ CALL ProyectoTresDemo.usuarioFindByPk(?) }";
    private final static String SP_LISTAR_DOCTORES = "{ CALL ProyectoTresDemo.listar_doctores() }";
    private final static String SP_FIND_BY_PK_SERVICIO = "{ CALL ProyectoTresDemo.servicioFindByPk(?) }";
    private final static String SP_FIND_BY_PK_FARMACO = "{ CALL ProyectoTresDemo.farmacoFindByPk(?) }";
    private final static String SP_FIND_BY_PK_PRESENTACION = "{ CALL ProyectoTresDemo.presentacionFindByPk(?) }";
    private final static String SP_FIND_BY_PK_INGRESO = "{ CALL ProyectoTresDemo.ingresoFindByPk(?) }";
    private final static String SP_AGREGAR_SERVICIO_DOCTOR = "{ CALL ProyectoTresDemo.agregarServicioDoctor(?,?) }";
    private final static String SP_FIND_BY_PK_REVISION = "{ CALL ProyectoTresDemo.revisionFindByPk(?) }";
    private final static String SP_FIND_BY_PK_RECETA = "{ CALL ProyectoTresDemo.recetaFindByPk(?) }";

    public List<Usuario> listarUsuarios() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_USUARIOS);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setIdServicio(rs.getInt("idServicio"));
                usuario.setNombreServicio(rs.getString("SERVICIO"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return usuarios;
    }

    public List<Servicio> listarServicios() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Servicio> servicios = new ArrayList<Servicio>();
        Servicio servicio = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_SERVICIOS);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getInt("idServicio"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicios.add(servicio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return servicios;
    }

    public List<Revision> listarRevisiones() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Revision> revisiones = new ArrayList<Revision>();
        Revision revision = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_REVISIONES);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                revision = new Revision();
                revision.setIdRevision(rs.getInt("idRevision"));
                revision.setIdDoctor(rs.getInt("idDoctor"));
                revision.setNombreDoctor(rs.getString("DOCTOR"));
                revision.setIdIngreso(rs.getInt("idIngreso"));
                revision.setNombrePaciente(rs.getString("PACIENTE"));
                revision.setFechaRevision(rs.getString("fechaRevision"));
                revision.setInforme(rs.getString("informe"));
                revisiones.add(revision);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return revisiones;
    }

    public List<Receta> listarRecetas() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Receta> recetas = new ArrayList<Receta>();
        Receta receta = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_RECETAS);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                receta = new Receta();
                receta.setIdReceta(rs.getInt("idRecetas"));
                receta.setIdFarmaco(rs.getInt("idFarmaco"));
                receta.setMedicamento(rs.getString("MEDICAMENTO"));
                receta.setFechaReceta(rs.getString("fechaReceta"));
                receta.setCantidad(rs.getInt("cantidad"));
                receta.setIdPresentacion(rs.getInt("idPresentacion"));
                receta.setPresentacionFarmaco(rs.getString("PRESENTACION"));
                receta.setIdDoctor(rs.getInt("idFacultivo"));
                receta.setNombreDoctor(rs.getString("DOCTOR"));
                recetas.add(receta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return recetas;
    }

    public List<Presentacion> listarPresentacion() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Presentacion> presentaciones = new ArrayList<Presentacion>();
        Presentacion presentacion = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_PRESENTACION);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                presentacion = new Presentacion();
                presentacion.setIdPresentacion(rs.getInt("id"));
                presentacion.setDescripcion(rs.getString("descripcion"));
                presentaciones.add(presentacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return presentaciones;
    }

    public List<Paciente> listarPaciente() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> pacientes = new ArrayList<Paciente>();
        Paciente paciente = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_PACIENTES);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idHistoriaClinica"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setIdSeguroSocial(rs.getInt("idSeguroSocial"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setTelefono(rs.getInt("telefono"));
                paciente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                pacientes.add(paciente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return pacientes;
    }

    public List<Ingreso> listarIngresos() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Ingreso> ingresos = new ArrayList<Ingreso>();
        Ingreso ingreso = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_INGRESOS);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                ingreso = new Ingreso();
                ingreso.setIdIngresos(rs.getInt("id"));
                ingreso.setIdPaciente(rs.getInt("idHistoriaClinica"));
                ingreso.setNombrePaciente(rs.getString("PACIENTE"));
                ingreso.setIdServicio(rs.getInt("idServicio"));
                ingreso.setNombreServicio(rs.getString("SERVICIO"));
                ingreso.setFechaIngreso(rs.getString("fechaIngreso"));
                ingreso.setFechaSalida(rs.getString("fechaSalida"));
                ingresos.add(ingreso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return ingresos;
    }

    public List<Farmaco> listarFarmaco() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Farmaco> farmacos = new ArrayList<Farmaco>();
        Farmaco farmaco = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_FARMACOS);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                farmaco = new Farmaco();
                farmaco.setIdFarmaco(rs.getInt("idRegistro"));
                farmaco.setNombreComercial(rs.getString("nombreComercial"));
                farmaco.setNombreClinico(rs.getString("nombreClinico"));
                farmaco.setCompuestoClinico(rs.getString("compuestoQuimico"));
                farmaco.setUbicacion(rs.getString("ubicacion"));
                farmaco.setCodigoProveedor(rs.getString("codigoProveedor"));
                farmacos.add(farmaco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return farmacos;
    }

    public List<FarmacoPresentacion> listarFarmacoPresentacion() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<FarmacoPresentacion> presentacionesFarmaco = new ArrayList<FarmacoPresentacion>();
        FarmacoPresentacion farmacoPresentacion = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_FARMACO_PRESENTACION);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                farmacoPresentacion = new FarmacoPresentacion();
                farmacoPresentacion.setIdFarmaco(rs.getInt("idRegistro"));
                farmacoPresentacion.setNombreComercial(rs.getString("nombreComercial"));
                farmacoPresentacion.setNombrClinico(rs.getString("nombreClinico"));
                farmacoPresentacion.setCompuestoQuimico(rs.getString("compuestoQuimico"));
                farmacoPresentacion.setUbicacion(rs.getString("ubicacion"));
                farmacoPresentacion.setCodigoProveedor(rs.getString("codigoProveedor"));
                farmacoPresentacion.setIdPresentacion(rs.getInt("idPresentacion"));
                farmacoPresentacion.setNombrePresentacion(rs.getString("descripcion"));
                farmacoPresentacion.setPrecio(rs.getInt("precio"));
                presentacionesFarmaco.add(farmacoPresentacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return presentacionesFarmaco;
    }

    public List<DetalleIngresosRevisionReceta> listarDetalleIngresosRevisionRecetas() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<DetalleIngresosRevisionReceta> detalleIngresosRevisionRecetas = new ArrayList<DetalleIngresosRevisionReceta>();
        DetalleIngresosRevisionReceta detalleIngresosRevisionReceta = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_DETALLE_INGRESO_REVISION_RECETA);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                detalleIngresosRevisionReceta = new DetalleIngresosRevisionReceta();
                detalleIngresosRevisionReceta.setIdIngreso(rs.getInt("idIngreso"));
                detalleIngresosRevisionReceta.setNombrePaciente(rs.getString("PACIENTE"));
                detalleIngresosRevisionReceta.setIdRevision(rs.getInt("idRevision"));
                detalleIngresosRevisionReceta.setNombreDoctor(rs.getString("DOCTOR"));
                detalleIngresosRevisionReceta.setIdReceta(rs.getInt("idReceta"));
                detalleIngresosRevisionReceta.setReceta(rs.getString("RECETA"));
                detalleIngresosRevisionReceta.setCantidad(rs.getInt("CANTIDAD"));
                detalleIngresosRevisionRecetas.add(detalleIngresosRevisionReceta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return detalleIngresosRevisionRecetas;
    }

    public void crearUsuario(String nombre, String correo, String contra, String direccion, String telefono, String tipoUsuario, Integer idServicio) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_USUARIO);
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contra);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setString(6, tipoUsuario);
            stmt.setInt(7, idServicio);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearServicio(String nombreServicio) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_SERVICIO);
            stmt.setString(1, nombreServicio);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearRevisionReceta(Integer idIngreso, Integer idRevision, Integer idReceta) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_REVISION_RECETA);
            stmt.setInt(1, idIngreso);
            stmt.setInt(2, idRevision);
            stmt.setInt(3, idReceta);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearRevision(Integer idDoctor, Integer idIngreso, String fechaRevision, String informe) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_REVISION);
            stmt.setInt(1, idDoctor);
            stmt.setInt(2, idIngreso);
            stmt.setString(3, fechaRevision);
            stmt.setString(4, informe);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearReceta(Integer idFarmaco, String fechReceta, Integer cantidad, Integer idPresentacion, Integer idDoctor) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_RECETA);
            stmt.setInt(1, idFarmaco);
            stmt.setString(2, fechReceta);
            stmt.setInt(3, cantidad);
            stmt.setInt(4, idPresentacion);
            stmt.setInt(5, idDoctor);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearPresentacion(String nombrePresentacion) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_PRESENTACION);
            stmt.setString(1, nombrePresentacion);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearPaciente(String nombre, Integer idSeguroSocial, String direccion, String telefono, String fechaNacimiento) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_PACIENTE);
            stmt.setString(1, nombre);
            stmt.setInt(2, idSeguroSocial);
            stmt.setString(3, direccion);
            stmt.setString(4, telefono);
            stmt.setString(5, fechaNacimiento);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearIngreso(Integer idPaciente, Integer idServicio, String fechaIngreso) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_INGRESO);
            stmt.setInt(1, idPaciente);
            stmt.setInt(2, idServicio);
            stmt.setString(3, fechaIngreso);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearFarmacoPresentacion(Integer idFarmaco, Integer idPresentacion, Integer precio) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_FARMACO_PRESENTACION);
            stmt.setInt(1, idFarmaco);
            stmt.setInt(2, idPresentacion);
            stmt.setInt(3, precio);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void crearFarmaco(String nombreComercial, String nombreClinico, String compuestoQuimico, String ubicacion, String codigoProveedor) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_CREAR_FARMACO);
            stmt.setString(1, nombreComercial);
            stmt.setString(2, nombreClinico);
            stmt.setString(3, compuestoQuimico);
            stmt.setString(4, ubicacion);
            stmt.setString(5, codigoProveedor);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarUsuario(Integer id, String nombre, String direccion, String telefono) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_USUARIO);
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, direccion);
            stmt.setString(4, telefono);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarServicio(Integer id, String descripcion) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_SERVICIO);
            stmt.setInt(1, id);
            stmt.setString(2, descripcion);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarRevision(Integer id, String informe) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_REVISION);
            stmt.setInt(1, id);
            stmt.setString(2, informe);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarReceta(Integer id, Integer cantidad) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_RECETA);
            stmt.setInt(1, id);
            stmt.setInt(2, cantidad);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarPresentacion(Integer id, String descripcion) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_PRESENTACION);
            stmt.setInt(1, id);
            stmt.setString(2, descripcion);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarPaciente(Integer id, String nombre, Integer idSeguroSocial, String direccion, String telefono) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_PACIENTE);
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, idSeguroSocial);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarIngreso(Integer id, String fechaSalida) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_INGRESO);
            stmt.setInt(1, id);
            stmt.setString(2, fechaSalida);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarFarmacoPresentacion(Integer idRegistro, Integer idPresentacion, Integer precio) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_FARMACO_PRESENTACION);
            stmt.setInt(1, idRegistro);
            stmt.setInt(2, idPresentacion);
            stmt.setInt(3, precio);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void editarFarmaco(Integer idRegistro, String nombreComercial, String nombreClinico, String compuestoQuimico, String ubicacion, String codigoProveedor) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_EDITAR_FARMACO);
            stmt.setInt(1, idRegistro);
            stmt.setString(2, nombreComercial);
            stmt.setString(3, nombreClinico);
            stmt.setString(4, compuestoQuimico);
            stmt.setString(5, ubicacion);
            stmt.setString(6, codigoProveedor);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void eliminarUsuario(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_ELIMINAR_USUARIO);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void eliminarServicio(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_ELIMINAR_SERVICIO);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void eliminarPresentacion(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_ELIMINAR_PRESENTACION);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void eliminarFarmacoPresentacion(Integer idMedicamento, Integer idPresentacion) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_ELIMINAR_FARMACO_PRESENTACION);
            stmt.setInt(1, idMedicamento);
            stmt.setInt(2, idPresentacion);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public void eliminarFarmaco(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_ELIMINAR_FARMACO);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public Usuario login(String correo, String contra) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            stmt = conn.prepareCall(SP_LOGIN);
            stmt.setString(1, correo);
            stmt.setString(2, contra);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setIdServicio(rs.getInt("idServicio"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return usuario;
    }

    public Paciente findByPkPaciente(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_PACIENTE);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idHistoriaClinica"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setIdSeguroSocial(rs.getInt("idSeguroSocial"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setTelefono(rs.getInt("telefono"));
                paciente.setFechaNacimiento(rs.getString("fechaNacimiento"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return paciente;
    }

    public Usuario findByPkUsuario(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_USUARIO);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setIdUsuario(rs.getInt("idServicio"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return usuario;
    }

    public List<Usuario> listarDoctores() {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            stmt = conn.prepareCall(SP_LISTAR_DOCTORES);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setIdUsuario(rs.getInt("idServicio"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return usuarios;
    }

    public Servicio findByPkServicio(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Servicio servicio = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_SERVICIO);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getInt("idServicio"));
                servicio.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return servicio;
    }

    public Farmaco findByPkFarmaco(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Farmaco farmaco = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_FARMACO);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                farmaco = new Farmaco();
                farmaco.setIdFarmaco(rs.getInt("idRegistro"));
                farmaco.setNombreComercial(rs.getString("nombreComercial"));
                farmaco.setNombreClinico(rs.getString("nombreClinico"));
                farmaco.setCompuestoClinico(rs.getString("compuestoQuimico"));
                farmaco.setUbicacion(rs.getString("ubicacion"));
                farmaco.setCodigoProveedor(rs.getString("codigoProveedor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return farmaco;
    }

    public Presentacion findByPkPresentacion(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Presentacion presentacion = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_PRESENTACION);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                presentacion = new Presentacion();
                presentacion.setIdPresentacion(rs.getInt("id"));
                presentacion.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return presentacion;
    }

    public Ingreso findByPkIngreso(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Ingreso ingreso = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_INGRESO);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                ingreso = new Ingreso();
                ingreso.setIdIngresos(rs.getInt("id"));
                ingreso.setIdPaciente(rs.getInt("idHistoriaClinica"));
                ingreso.setIdServicio(rs.getInt("idServicio"));
                ingreso.setFechaIngreso(rs.getString("fechaIngreso"));
                ingreso.setFechaSalida(rs.getString("fechaSalida"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return ingreso;
    }

    public void agregarServicioDoctor(Integer idDoctor, Integer idServicio) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareCall(SP_AGREGAR_SERVICIO_DOCTOR);
            stmt.setInt(1, idDoctor);
            stmt.setInt(2, idServicio);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
    }

    public Revision findByPkRevision(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Revision revision = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_REVISION);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                revision = new Revision();
                revision.setIdRevision(rs.getInt("idRevision"));
                revision.setIdDoctor(rs.getInt("idDoctor"));
                revision.setIdIngreso(rs.getInt("idIngreso"));
                revision.setFechaRevision(rs.getString("fechaRevision"));
                revision.setInforme(rs.getString("informe"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return revision;
    }

    public Receta findByPkReceta(Integer id) {
        Connection conn = conectorJDBC.conectar();
        CallableStatement stmt = null;
        ResultSet rs = null;
        Receta receta = null;
        try {
            stmt = conn.prepareCall(SP_FIND_BY_PK_RECETA);
            stmt.setInt(1, id);
            stmt.execute();
            rs = (ResultSet) stmt.getResultSet();
            while (rs.next()) {
                receta = new Receta();
                receta.setIdReceta(rs.getInt("idRecetas"));
                receta.setIdFarmaco(rs.getInt("idFarmaco"));
                receta.setFechaReceta(rs.getString("fechaReceta"));
                receta.setCantidad(rs.getInt("cantidad"));
                receta.setIdPresentacion(rs.getInt("idPresentacion"));
                receta.setIdDoctor(rs.getInt("idFacultivo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conectorJDBC.cerrarConexion(conn, stmt, rs);
        }
        return receta;
    }

}
