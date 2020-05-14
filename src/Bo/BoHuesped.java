/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHuesped;
import Excepcion.BuscarHuespedException;
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHuespedException;
import Excepcion.ModificarHuespedException;
import Excepcion.TelefonoException;
import Fabrica.FactoryDAO;
import Modelo.Huesped;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class BoHuesped {

    private final IDAOHuesped dao;
    private final DateFormat formato;
    private final Pattern pattern;

    public BoHuesped() {
        dao = FactoryDAO.getFabrica().crearDAOHuesped();
        formato = DateFormat.getDateInstance();
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public void guardar(String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado) throws CorreoException, DatosIncompletosException, CedulaException, TelefonoException, GuardarHuespedException, CorreoFormatoException {
        verificarCorreo(correo);
        Huesped huesped = new Huesped(0, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, nacionalidad, contrasena, tipo, estado);
        if (!dao.guardarHuesped(huesped)) {
            throw new GuardarHuespedException();
        }
    }

    public Huesped buscar(String cedula) throws BuscarHuespedException {
        Huesped huesped = dao.buscarHuesped(cedula);
        if (huesped == null) {
            throw new BuscarHuespedException();
        }
        return huesped;
    }

    public void modificar(String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado) throws CorreoException, DatosIncompletosException, BuscarHuespedException, CedulaException, TelefonoException, ModificarHuespedException, CorreoFormatoException {
        verificarCorreo(correo);
        Huesped huesped = new Huesped(buscar(cedula).getId(), cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, nacionalidad, contrasena, tipo, estado);
        if (!dao.modificarHuesped(huesped)) {
            throw new ModificarHuespedException();
        }
    }

    public ArrayList<Huesped> listarHuesped() {
        return dao.listarHuesped();
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

    private void verificarCorreo(String correo) throws  DatosIncompletosException, CorreoFormatoException {
        if (correo == null) {
            throw new DatosIncompletosException();
        }
        Matcher mather = pattern.matcher(correo);
        if (mather.find()) {
        } else {
            throw new CorreoFormatoException();
        }
    }
}
