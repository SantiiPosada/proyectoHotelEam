/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoRecepcionista;
import Excepcion.CedulaException;
import Excepcion.ComboBoxException;
import Excepcion.CorreoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarRecepcionistaException;
import Excepcion.ModificarRecepcionistaException;
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
    
    public void guardarRecepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CorreoException, CedulaException, GuardarRecepcionistaException {
        
        bo.guardarRecepcionista(id, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena);
    }

    public Recepcionista buscarRecepcionista(int id) {
        return bo.buscarRecepcionista(id);
    }

    public void modificarEstudiante(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CorreoException, ModificarRecepcionistaException {
        
        bo.modificarRecepcionista(id, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena);
        
    }
    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException,NumberFormatException, ComboBoxException {
            return bo.filtrar(opcion, accion);
        }
}
