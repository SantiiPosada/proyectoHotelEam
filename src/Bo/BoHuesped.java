/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHuesped;
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHuespedException;
import Excepcion.TelefonoException;
import Fabrica.FactoryDAO;
import Modelo.Huesped;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author santiago
 */
public class BoHuesped {

    private IDAOHuesped dao;
    private DateFormat formato;
    private Pattern pattern;

    public BoHuesped() {
        dao = FactoryDAO.getFabrica().crearDAOHuesped();
        formato = DateFormat.getDateInstance();
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public void guardar( String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado) throws CorreoException, DatosIncompletosException, CedulaException, TelefonoException, GuardarHuespedException{
        verificarCorreo(correo);
        Huesped huesped=new Huesped(0, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, nacionalidad, contrasena, tipo, estado);
        if(!dao.guardarHuesped(huesped)){
          throw new   GuardarHuespedException();
        }
        
    }
    
    
    
    private void verificarCorreo(String correo) throws CorreoException, DatosIncompletosException {
        if(correo==null){
            throw new DatosIncompletosException();
        }
        Matcher mather = pattern.matcher(correo);

        if (mather.find()) {

        } else {
            throw new CorreoException();
        }

    }

}
