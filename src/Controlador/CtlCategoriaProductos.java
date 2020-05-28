/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCategoriaProductos;
import Excepcion.BuscarHabitacionException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarCategoriaProductosException;
import Excepcion.ModificarCategoriaProductosException;
import Excepcion.NombreCategoriaException;
import Modelo.CategoriaProducto;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlCategoriaProductos {

    BOCategoriaProductos bo;

    public CtlCategoriaProductos() {
        bo = new BOCategoriaProductos();
    }

    public void guardarCategoriaProductos(String nombre, String descripcion, String estado) throws NombreCategoriaException, DatosIncompletosException, GuardarCategoriaProductosException {
        bo.guardarCategoriaProductos(nombre, descripcion, estado);
    }

    public CategoriaProducto buscarCategoriaProductos(String nombre) throws DatosIncompletosException, BuscarHabitacionException {
        return bo.buscarCategoriaProducto(nombre);
    }

    public void modificarCategoriaProductos(String nombre, String descripcion, String estado) throws DatosIncompletosException, BuscarHabitacionException, NombreCategoriaException, ModificarCategoriaProductosException {
        bo.modificarCategoriaProducto(nombre, descripcion, estado);
    }

    public ArrayList<CategoriaProducto> listarCategoriaProductos() {
        return bo.listarCategoriaProductos();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        return bo.obtenerDatoJtextArea(x);
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        return bo.filtrar(opcion, accion);
    }

    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }
}
