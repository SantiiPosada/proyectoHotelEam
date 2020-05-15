/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoRecepcionista;
import Excepcion.BuscarRecepcionistaException;
import Excepcion.CedulaException;
import Excepcion.ComboBoxException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarRecepcionistaException;
import Excepcion.ModificarRecepcionistaException;
import Excepcion.TelefonoException;
import Modelo.Recepcionista;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlRecepcionista {

    BoRecepcionista bo;

    public CtlRecepcionista() {
        bo = new BoRecepcionista();
    }

    public void guardarRecepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CedulaException, GuardarRecepcionistaException, TelefonoException, CorreoFormatoException, CorreoException {

        bo.guardarRecepcionista(id, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena);
    }

    public Recepcionista buscarRecepcionista(String cedula) throws BuscarRecepcionistaException {
        return bo.buscarRecepcionista(cedula);
    }

    public void modificarRecepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CorreoException, ModificarRecepcionistaException, CedulaException, TelefonoException, CorreoFormatoException, BuscarRecepcionistaException {

        bo.modificarRecepcionista(id, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena);

    }

    public void EliminarRecepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CorreoException, ModificarRecepcionistaException, CedulaException, TelefonoException {
        bo.EliminarRecepcionista(id, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena);
    }

    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        return bo.filtrar(opcion, accion);
    }
}
