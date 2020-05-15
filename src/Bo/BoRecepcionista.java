/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAORecepcionista;
import Excepcion.BuscarRecepcionistaException;
import Excepcion.CedulaException;
import Excepcion.ComboBoxException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarRecepcionistaException;
import Excepcion.ModificarRecepcionistaException;
import Excepcion.TelefonoException;
import Fabrica.FactoryDAO;
import Modelo.Recepcionista;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BoRecepcionista {

    IDAORecepcionista daoRecepcionista;
    DateFormat formato;
    private int indice;
    Pattern pattern;

    public BoRecepcionista() {
        daoRecepcionista = FactoryDAO.getFabrica().crearDAORecepcionista();
        formato = DateFormat.getDateInstance();
        indice = 0;
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public void guardarRecepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CedulaException, GuardarRecepcionistaException, TelefonoException, CorreoFormatoException, CorreoException {
        verificarCorreo(correo);
        Recepcionista recepcionista = new Recepcionista(id, cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena, "Disponible");

        boolean condicionrecepcionista = daoRecepcionista.guardarRecepcionista(recepcionista);

        if (condicionrecepcionista == true) {

        } else {

            throw new GuardarRecepcionistaException();

        }

    }

    public void verificarCorreo(String correo) throws DatosIncompletosException, CorreoFormatoException {

        if (correo == null) {
            throw new DatosIncompletosException();
        }
        Matcher mather = pattern.matcher(correo);

        if (mather.find()) {

        } else {
            throw new CorreoFormatoException();
        }

    }

    private void VerificarCedulaExistente(String cedula) throws CedulaException {

        ArrayList<Recepcionista> listarecepcionista = daoRecepcionista.listarRecepcionista();

        for (Recepcionista recepcionista : listarecepcionista) {
            if (recepcionista.getCedula().equals(cedula)) {
                throw new CedulaException();

            }
        }

    }

    public Recepcionista buscarRecepcionista(String cedula) throws BuscarRecepcionistaException, DatosIncompletosException {
        if (cedula == null) {
            throw new DatosIncompletosException();
        }
        Recepcionista recepcionista = daoRecepcionista.buscarRecepcionista(cedula);
        if (recepcionista == null) {
            throw new BuscarRecepcionistaException();
        }
        return recepcionista;
    }

    public void modificarRecepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CorreoException, ModificarRecepcionistaException, CedulaException, TelefonoException, CorreoFormatoException, BuscarRecepcionistaException {
        verificarCorreo(correo);
        Recepcionista recepcionistanuevo = new Recepcionista(buscarRecepcionista(cedula).getId(), cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena, "Disponible");

        boolean condicionRecepcionista = daoRecepcionista.modificarRecepcionista(recepcionistanuevo);

        if (condicionRecepcionista == true) {

        } else {

            throw new ModificarRecepcionistaException();

        }

    }

    public void EliminarRecepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena) throws DatosIncompletosException, CorreoException, ModificarRecepcionistaException, CedulaException, TelefonoException, BuscarRecepcionistaException {

        Recepcionista recepcionistanuevo = new Recepcionista(buscarRecepcionista(cedula).getId(), cedula, nombrecompleto, genero, correo, telefono, fechanacimiento, contrasena, "No Disponible");

        boolean condicionRecepcionista = daoRecepcionista.modificarRecepcionista(recepcionistanuevo);

        if (condicionRecepcionista == true) {

        } else {

            throw new ModificarRecepcionistaException();

        }

    }

    public ArrayList<Recepcionista> listarRecepcionistas() {
        return daoRecepcionista.listarRecepcionista();

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
        ArrayList<Recepcionista> listarecepcionista = listarRecepcionistas();

        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Contrasena", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 9:
                        return true;
                    default:
                        return false;
                }
            }
        };

        listarecepcionista.forEach((Recepcionista) -> {

            String fecha = formato.format(Recepcionista.getFechanacimiento());
            if (Recepcionista.getEstado().equalsIgnoreCase("Disponible")) {
                modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});
            }

        });

        return modelo;
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion.equals("")) {
            throw new DatosIncompletosException();
        }

        String nombre = "";
        ArrayList<Recepcionista> listarecepcionistas = listarRecepcionistas();
        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Contrasena", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 9:
                        return true;
                    default:
                        return false;
                }
            }

        };

        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();

            case "Id":
                try {
                    int x = Integer.parseInt(accion);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();

                }
                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getId() == Integer.parseInt(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;

            case "Cedula":
                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getCedula().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;

            case "Nombre Completo":
                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getNombrecompleto().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;

            case "Genero":

                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getGenero().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;

            case "Correo":
                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getCorreo().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;

            case "Telefono":
                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getTelefono().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;
            case "Fecha Nacimiento":
                listarecepcionistas.forEach((Recepcionista) -> {
                    String fecha = formato.format(Recepcionista.getFechanacimiento());
                    if (fecha.equals(accion)) {

                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;

            case "Contrasena":
                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getContrasena().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;
            case "Estado":
                listarecepcionistas.forEach((Recepcionista) -> {
                    if (Recepcionista.getEstado().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(Recepcionista.getFechanacimiento());
                        modelo.addRow(new Object[]{Recepcionista.getId(), Recepcionista.getCedula(), Recepcionista.getNombrecompleto(), Recepcionista.getGenero(), Recepcionista.getCorreo(), Recepcionista.getTelefono(), fecha, Recepcionista.getContrasena(), Recepcionista.getEstado()});

                    }

                });
                return modelo;
            default:
                break;
        }
        return modelo;
    }

}
