/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoHuesped;
import Excepcion.BuscarHuespedException;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.CedulaRecepcionistaException;
import Excepcion.ComboBoxException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHuespedException;
import Excepcion.ModificarHuespedException;
import Excepcion.TelefonoException;
import Modelo.Huesped;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class CtlHuesped {

    BoHuesped bo;

    public CtlHuesped() {
        bo = new BoHuesped();
    }

    public void guardar(String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado) throws CorreoException, DatosIncompletosException, CedulaException, TelefonoException, GuardarHuespedException, CorreoFormatoException, CedulaAdministradorException, CedulaRecepcionistaException {
        bo.guardar(cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, nacionalidad, contrasena, tipo, estado);
    }

    public Huesped buscar(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return bo.buscar(cedula);
    }

    public void modificar(String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado) throws CorreoException, DatosIncompletosException, BuscarHuespedException, CedulaException, TelefonoException, ModificarHuespedException, CorreoFormatoException {
        bo.modificar(cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, nacionalidad, contrasena, tipo, estado);
    }

    public ArrayList<Huesped> listarHuesped() {
        return bo.listarHuesped();
    }
     public String obtenerDatoJtextFile(JTextField x){
         return bo.obtenerDatoJtextFile(x);
     }
      public String  obtenerDatoJComboBox(JComboBox x){
          return bo.obtenerDatoJComboBox(x);
      }
         public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
             return bo.filtrar(opcion, accion);
         }
     
      public DefaultTableModel listarElementos() {
          return bo.listarElementos();
      }
}
