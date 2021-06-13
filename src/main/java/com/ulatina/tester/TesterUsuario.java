/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.tester;

import com.ulatina.proyecto.model.Usuario;
import com.ulatina.proyecto.service.ControlProcAlmac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josepabloramirez
 */
public class TesterUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlProcAlmac control = new ControlProcAlmac();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = control.listarUsuarios();
        
        for(Usuario user : usuarios){
            System.out.println(user.getCorreo());
            System.out.println(user.getContrasena());
        }
    }
    
}
