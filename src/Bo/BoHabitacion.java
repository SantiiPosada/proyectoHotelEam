/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHabitacion;
import Excepcion.BuscarHabitacionException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHabitacionException;
import Excepcion.ImagenException;
import Excepcion.ModificarHabitacionException;
import Excepcion.NombreHabitacionException;
import Excepcion.NombreImagenException;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BoHabitacion {

    private final IDAOHabitacion dao;

    public BoHabitacion() {
        dao = FactoryDAO.getFabrica().crearDAOHabitacIon();
    }

    public void guardarHabitacion(String nombre, String piso, String bano, String sala, String estado, String nombreImagen, Icon imagen, String descripcion, String valorPorNoche) throws GuardarHabitacionException, NombreHabitacionException, NombreImagenException, ImagenException, DatosIncompletosException, BuscarHabitacionException {
        Habitacion habitacion = new Habitacion(buscarHabitacion(nombre).getId(), nombre, piso, bano, sala, estado, nombreImagen, imagen, descripcion, valorPorNoche);
        if (!dao.guardarHabitacion(habitacion)) {
            throw new GuardarHabitacionException();
        }
    }

    public Habitacion buscarHabitacion(String nombre) throws DatosIncompletosException, BuscarHabitacionException {
        if (nombre == null) {
            throw new DatosIncompletosException();
        }
        Habitacion habitacion = dao.buscarHabitacion(nombre);
        if (habitacion == null) {
            throw new BuscarHabitacionException();
        }
        return habitacion;
    }

    public void modificarHabitacion(String nombre, String piso, String bano, String sala, String estado, String nombreImagen, Icon imagen, String descripcion, String valorPorNoche) throws DatosIncompletosException, BuscarHabitacionException, NombreHabitacionException, NombreImagenException, ImagenException, ModificarHabitacionException {
        Habitacion habitacion = new Habitacion(buscarHabitacion(nombre).getId(), nombre, piso, bano, sala, estado, nombreImagen, imagen, descripcion, valorPorNoche);
        if (!dao.modificarHabitacion(habitacion)) {
            throw new ModificarHabitacionException();
        }
    }

    public ArrayList<Habitacion> listarHabitacion() {
        return dao.listarHabitacion();
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

        ArrayList<Habitacion> lista = listarHabitacion();
        String nombreColumnas[] = {"Id", "Nombre", "Piso", "Baño", "Sala", "Estado", "Nombre Imagen", "Descripcion", "Valor por noche"};
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

        lista.forEach((habitacion) -> {

            if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {
                modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
            }

        });

        return modelo;
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion == null) {
            throw new DatosIncompletosException();
        }

        String nombre = "";
        ArrayList<Habitacion> lista = listarHabitacion();
        String nombreColumnas[] = {"Id", "Nombre", "Piso", "Baño", "Sala", "Estado", "Nombre Imagen", "Descripcion", "Valor por noche"};
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

            case "Nombre":
                lista.forEach((habitacion) -> {
                    if (habitacion.getNombre().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;

            case "Piso":
                lista.forEach((habitacion) -> {
                    if (habitacion.getPiso().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;

            case "Baño":

                lista.forEach((habitacion) -> {
                    if (habitacion.getBano().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;

            case "Sala":
                lista.forEach((habitacion) -> {
                    if (habitacion.getSala().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;

            case "Estado":
                lista.forEach((habitacion) -> {
                    if (habitacion.getEstado().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;
            case "Nombre Imagen":
                lista.forEach((habitacion) -> {

                    if (habitacion.getNombreImagen().equalsIgnoreCase(accion)) {
                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;

            case "Descripcion":
                lista.forEach((habitacion) -> {
                    if (habitacion.getDescripcion().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;

            case "Valor por noche":
                lista.forEach((habitacion) -> {
                    if (habitacion.getValorPorNoche().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getNombreImagen(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }
                });
                return modelo;

            default:
                break;
        }
        return modelo;
    }
}
