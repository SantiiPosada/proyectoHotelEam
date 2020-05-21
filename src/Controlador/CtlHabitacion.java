/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoHabitacion;
import Excepcion.BuscarHabitacionException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHabitacionException;
import Excepcion.ModificarHabitacionException;
import Excepcion.NombreHabitacionException;
import Modelo.Habitacion;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlHabitacion {

    BoHabitacion bo;

    public CtlHabitacion() {
        bo = new BoHabitacion();

    }

    public void guardarHabitacion( String nombre, String piso, String bano, String sala, String estado, byte[] imagen, String descripcion, String valorPorNoche) throws GuardarHabitacionException, DatosIncompletosException, NombreHabitacionException {
        bo.guardarHabitacion( nombre, piso, bano, sala, estado, imagen, descripcion, valorPorNoche);
    }

    public Habitacion buscarHabitacion(String nombre) throws DatosIncompletosException, BuscarHabitacionException {
        return bo.buscarHabitacion(nombre);
    }

    public void modificarHabitacion( String nombre, String piso, String bano, String sala, String estado, byte[] imagen, String descripcion, String valorPorNoche) throws DatosIncompletosException, ModificarHabitacionException, NombreHabitacionException, BuscarHabitacionException {
        bo.modificarHabitacion(nombre, piso, bano, sala, estado, imagen, descripcion, valorPorNoche);
    }

    public ArrayList<Habitacion> listarHabitacion() {
        return bo.listarHabitacion();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        return bo.filtrar(opcion, accion);
    }

    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }

}
