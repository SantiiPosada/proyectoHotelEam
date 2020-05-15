/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOLogIn;
import Excepcion.DatosIncompletosException;
import Excepcion.LogInAdministradorException;
import Excepcion.LogInHuespedException;
import Excepcion.LogInRecepcionistaException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class CtlLogIn {

    private final BOLogIn bo;

    public CtlLogIn() {
        bo = new BOLogIn();
    }

    public void LogInHusped(String cedula, String contrasena) throws LogInHuespedException {
        bo.LogInHusped(cedula, contrasena);
    }

    public void LogInRecepcionista(String cedula, String contrasena) throws LogInRecepcionistaException {
        bo.LogInRecepcionista(cedula, contrasena);
    }

    public void LogInAdministrador(String cedula, String contrasena) throws LogInAdministradorException {
        bo.LogInAdministrador(cedula, contrasena);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }
      public String IniciarSesion(String cedula,String contrasena,String tipoUsuario)throws DatosIncompletosException,LogInAdministradorException,LogInHuespedException,LogInRecepcionistaException{
          return bo.IniciarSesion(cedula, contrasena, tipoUsuario);
      }
}
