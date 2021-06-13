/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.proyecto.service;

import com.ulatina.proyecto.model.Ingreso;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author josepabloramirez
 */
@FacesConverter(value = "ingresoConverter")
public class IngresoConverter implements Converter, Serializable {

    private static final long serialVersionUID = 1L;

    ControlProcAlmac control;

    public IngresoConverter() {
        control = new ControlProcAlmac();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        if (submittedValue != null && submittedValue.trim().length() > 0) {
            try {
                System.out.println("INGRESO SELECCIONADO " + submittedValue);
                Ingreso ingreso = control.findByPkIngreso(new Integer(submittedValue));
                System.out.println(ingreso.getIdIngreso());
                return ingreso;
            } catch (Exception exception) {
                exception.printStackTrace();
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No es un Tipo válido."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Ingreso) value).getIdIngreso());
        }
    }

}
