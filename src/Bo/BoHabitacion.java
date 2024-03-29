/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHabitacion;
import Excepcion.BuscarHabitacionException;
import Excepcion.CargarImagenException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHabitacionException;
import Excepcion.ImagenException;
import Excepcion.ModificarHabitacionException;
import Excepcion.NombreHabitacionException;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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

    /**
     * Metodo encargado de convertir un File a bytes
     *
     * @param file ruta de la imagen
     * @return imagen convertida en bytes
     * @throws CargarImagenException si hay algun error al convertir el File
     */
    public byte[] cargarImagenBytes(File file) throws CargarImagenException {
        try {
            byte[] icono = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(icono);
            return icono;
        } catch (IOException e) {
            throw new CargarImagenException();
        }
    }

    /**
     * Metodo encargado de convertir bytes en un BufferedImage
     *
     * @param bytes que se desea pasar a un BufferedImage
     * @return bytes convertidos en InputStream
     * @throws CargarImagenException si hay algun error al convertitir los bytes
     */
    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        try {
            BufferedImage imagen = null;
            InputStream input = new ByteArrayInputStream(bytes);
            imagen = ImageIO.read(input);
            return imagen;
        } catch (IOException e) {
            throw new CargarImagenException();
        }
    }

    public void guardarHabitacion(String nombre, String piso, String bano, String sala, String estado, File ruta, String descripcion, String valorPorNoche) throws GuardarHabitacionException, DatosIncompletosException, NombreHabitacionException, CargarImagenException {

        Habitacion habitacion = new Habitacion(0, nombre, piso, bano, sala, estado, cargarImagenBytes(ruta), descripcion, valorPorNoche);
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

    public void modificarHabitacion(String nombre, String piso, String bano, String sala, String estado, File ruta, String descripcion, String valorPorNoche) throws DatosIncompletosException, ModificarHabitacionException, NombreHabitacionException, BuscarHabitacionException, CargarImagenException {
        Habitacion habitacion = new Habitacion(buscarHabitacion(nombre).getId(), nombre, piso, bano, sala, estado, cargarImagenBytes(ruta), descripcion, valorPorNoche);
        if (!dao.modificarHabitacion(habitacion)) {
            throw new ModificarHabitacionException();
        }
    }

    public void modificarHabitacion2(String nombre, String piso, String bano, String sala, String estado, String descripcion, String valorPorNoche) throws DatosIncompletosException, ModificarHabitacionException, NombreHabitacionException, BuscarHabitacionException {
        Habitacion habitacion = new Habitacion(buscarHabitacion(nombre).getId(), nombre, piso, bano, sala, estado, null, descripcion, valorPorNoche);
        if (!dao.modificarHabitacion2(habitacion)) {
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

    public String obtenerDatoJtextArea(JTextArea x) {
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
        String nombreColumnas[] = {"Id", "Nombre", "Piso", "Baño", "Sala", "Estado", "Descripcion", "Valor por noche"};
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

                modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});

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
        String nombreColumnas[] = {"Id", "Nombre", "Piso", "Baño", "Sala", "Estado", "Descripcion", "Valor por noche"};
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
//Id

        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();
    
            case "Nombre":
                lista.forEach((habitacion) -> {
                    if (habitacion.getNombre().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"

                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;
//Nombre
//Piso

            case "Piso":
                lista.forEach((habitacion) -> {
                    if (habitacion.getPiso().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;
//Bano

            case "Bano":

                lista.forEach((habitacion) -> {
                    if (habitacion.getBano().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;
//Sala

            case "Sala":
                lista.forEach((habitacion) -> {
                    if (habitacion.getSala().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;
//Estado

            case "Estado":
                lista.forEach((habitacion) -> {
                    if (habitacion.getEstado().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;
            //Descripcion
//Valor por noche
            case "Descripcion":
                lista.forEach((habitacion) -> {
                    if (habitacion.getDescripcion().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
                        }
                    }

                });
                return modelo;

            case "Valor por noche":
                lista.forEach((habitacion) -> {
                    if (habitacion.getValorPorNoche().equalsIgnoreCase(accion)) {

                        if (!habitacion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"

                            modelo.addRow(new Object[]{habitacion.getId(), habitacion.getNombre(), habitacion.getPiso(), habitacion.getBano(), habitacion.getSala(), habitacion.getEstado(), habitacion.getDescripcion(), habitacion.getValorPorNoche()});
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
