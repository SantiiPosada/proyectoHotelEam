/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOLogIn;
import Excepcion.DatosIncompletosException;
import Excepcion.LogInException;
import Fabrica.FactoryDAO;
import Modelo.Administrador;
import Modelo.Huesped;
import Modelo.Recepcionista;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class BOLogIn {

    private final IDAOLogIn dao;

    public BOLogIn() {
        dao = FactoryDAO.getFabrica().crearDAOLogIn();

    }

    public Huesped LogInHusped(String cedula, String contrasena) throws LogInException {
        Huesped huesped = dao.LogInHuesped(cedula, contrasena);

        if (huesped == null) {
            throw new LogInException();
        }
        return huesped;
    }

    public Recepcionista LogInRecepcionista(String cedula, String contrasena) throws LogInException {
        Recepcionista recepcionista = dao.LogInRecepcionista(cedula, contrasena);
        if (recepcionista == null) {
            throw new LogInException();
        }
        return recepcionista;
    }

    public Administrador LogInAdministrador(String cedula, String contrasena) throws LogInException {
        Administrador administrador = dao.LogInAdministrador(cedula, contrasena);
        if (administrador == null) {
            throw new LogInException();
        }
        return administrador;
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }

    public Object IniciarSesion(String cedula, String contrasena) throws DatosIncompletosException, LogInException {
String tipoUsuario=null;
        verificarDatos(cedula, contrasena, tipoUsuario);

        switch (tipoUsuario) {
            case "Huesped":
               return  LogInHusped(cedula, contrasena);

            case "Administrador":
                return LogInAdministrador(cedula, contrasena);
          
            case "Recepcionista":
                return LogInRecepcionista(cedula, contrasena);
               
            default:
                break;
        }
        return null;
    }

    private void verificarDatos(String cedula, String contrasena, String tipoUsuario) throws DatosIncompletosException {
        if (cedula == null || contrasena == null || tipoUsuario == null) {
            throw new DatosIncompletosException();
        }
    }

}
