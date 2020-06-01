/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOHistorialHospedaje;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlHistorialHospedaje {

    BOHistorialHospedaje bo;

    public CtlHistorialHospedaje() {
        bo = new BOHistorialHospedaje();
    }

    public DefaultTableModel listarElementosHistorial() {
        return bo.listarElementosHistorial();
    }

    public DefaultTableModel listarElementosReservacion(int idReservacion, int idHuesped) {
        return bo.listarElementosReservacion(idReservacion, idHuesped);
    }

    public DefaultTableModel listarElementosProductos(int idReservacion, int idHuesped) {
        return bo.listarElementosProductos(idReservacion, idHuesped);
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        return bo.filtrar(opcion, accion);
    }

    public String deDateaString(Date uDate) {
        return bo.deDateaString(uDate);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }
}
