/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOHistorialCuentaPersonal;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHistorialCuentaPersonalException;
import Excepcion.ModificarCantidadException;
import Excepcion.ModificarInventarioException;
import Excepcion.NombreProductoException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author mateo
 */
public class CtlHistorialCuentaPersonal {

    BOHistorialCuentaPersonal bo;

    public CtlHistorialCuentaPersonal() {
        bo = new BOHistorialCuentaPersonal();
    }

    public void guardarHistorialCuentaPersonal(int idCuentaPersonal, int idProducto, String cantidad) throws DatosIncompletosException, GuardarHistorialCuentaPersonalException, ModificarInventarioException, NombreProductoException, ModificarCantidadException {
        bo.guardarHistorialCuentaPersonal(idCuentaPersonal, idProducto, cantidad);
    }

    public DefaultComboBoxModel llenarComboBoxProductos(int idcategoria) {
        return bo.llenarComboBoxProductos(idcategoria);
    }

    public DefaultComboBoxModel llenarComboBoxCategoria() {
        return bo.llenarComboBoxCategoria();
    }

    public DefaultComboBoxModel llenarComboBoxReserva() {
        return bo.llenarComboBoxReservas();
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);

    }
}
