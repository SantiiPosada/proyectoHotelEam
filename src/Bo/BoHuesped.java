/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHuesped;
import Excepcion.BuscarHuespedException;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.ComboBoxException;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

    public void guardar(String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado) throws CorreoException, DatosIncompletosException, CedulaException, TelefonoException, GuardarHuespedException, CorreoFormatoException, CedulaAdministradorException ,CedulaHuespedException{
        verificarCorreo(correo);
        Huesped huesped = new Huesped(0, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, nacionalidad, contrasena, tipo, estado);
        if (!dao.guardarHuesped(huesped)) {
            throw new GuardarHuespedException();
        }
    }

    public Huesped buscar(String cedula) throws BuscarHuespedException, DatosIncompletosException {

        if (cedula == null) {
            throw new DatosIncompletosException();
        }
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

    public DefaultTableModel listarElementos() {

        ArrayList<Huesped> lista = listarHuesped();
        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 11:
                        return true;
                    default:
                        return false;
                }
            }
        };

        lista.forEach((huesped) -> {
            String fecha = formato.format(huesped.getFechanacimiento());
            if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
            }

        });

        return modelo;
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion == null) {
            throw new DatosIncompletosException();
        }

        String nombre = "";
        ArrayList<Huesped> lista = listarHuesped();
        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 11:
                        return true;
                    default:
                        return false;
                }
            }
        };

        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();

            case "Cedula":
                lista.forEach((huesped) -> {
                    if (huesped.getCedula().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;

            case "Nombre Completo":
                lista.forEach((huesped) -> {
                    if (huesped.getNombrecompleto().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;

            case "Genero":

                lista.forEach((huesped) -> {
                    if (huesped.getGenero().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;

            case "Correo":
                lista.forEach((huesped) -> {
                    if (huesped.getCorreo().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;

            case "Telefono":
                lista.forEach((huesped) -> {
                    if (huesped.getTelefono().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;
            case "Fecha Nacimiento":
                lista.forEach((huesped) -> {
                    String fecha = formato.format(huesped.getFechanacimiento());
                    if (fecha.equals(accion)) {
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;

            case "Contrasena":
                lista.forEach((huesped) -> {
                    if (huesped.getContrasena().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;
            case "Estado":
                lista.forEach((huesped) -> {
                    if (huesped.getEstado().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;
                   case "Tipo":
                lista.forEach((huesped) -> {
                    if (huesped.getTipo().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }
                });
                return modelo;
                    case "Nacionalidad":
                lista.forEach((huesped) -> {
                    if (huesped.getNacionalidad().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechanacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombrecompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }

                });
                return modelo;
            default:
                break;
        }
        return modelo;
    }

    private void verificarCorreo(String correo) throws DatosIncompletosException, CorreoFormatoException {
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
