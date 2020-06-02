/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.DAOMulta;
import Excepcion.BuscarHabitacionException;
import Excepcion.BuscarHuespedException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.ReservaHabitacion;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class BOCheckOut {

    private final BoHuesped BoHuesped;
    private final BOReserva BoReserva;
    private final BoHabitacion boHabitacion;
    private final BOCuentaPersonal boCuentaPersona;
    private final DAOMulta daoMulta;
    private ArrayList<ReservaHabitacion> listaReserva;

    public BOCheckOut() {
        BoHuesped = new BoHuesped();
        BoReserva = new BOReserva();
        boHabitacion = new BoHabitacion();
        boCuentaPersona = new BOCuentaPersonal();
        listaReserva = new ArrayList<>();
        daoMulta = new DAOMulta();
    }

    private void listarReservas() {

        listaReserva = BoReserva.listarReserva();
    }

    public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return BoHuesped.buscar(cedula);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }
      public ReservaHabitacion buscarReserva(int idReserva) {
        listarReservas();
        for (ReservaHabitacion reservaHabitacion : listaReserva) {
            if (reservaHabitacion.getId() == idReserva) {
                return reservaHabitacion;

            }
        }
        return null;
    }
      public Habitacion buscarHabitacion(int idReserva) throws BuscarHabitacionException {

        ReservaHabitacion reserva = null;

        for (ReservaHabitacion reservaHabitacion : listaReserva) {
            if (reservaHabitacion.getId() == idReserva) {
                reserva = reservaHabitacion;
                break;
            }
        }
        if (reserva == null) {
            throw new BuscarHabitacionException();
        }

        ArrayList<Habitacion> listaHabitacion = boHabitacion.listarHabitacion();

        for (Habitacion habitacion : listaHabitacion) {
            if (habitacion.getId() == reserva.getIdHabitacion()) {
                return habitacion;
            }
        }
        throw new BuscarHabitacionException();

    }
        public DefaultComboBoxModel llenarComboBox(int idHuesped) {
        listarReservas();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        listaReserva.stream().filter((reserva) -> (reserva.getEstado().equalsIgnoreCase("CheckIn"))).filter((reserva) -> (reserva.getIdHuesped() == idHuesped)).forEachOrdered((reserva) -> {
            modelo.addElement(reserva.getId());
        });
        return modelo;
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

}
