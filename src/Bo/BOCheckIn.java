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
import Excepcion.DiaException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.MultaException;
import Excepcion.anoException;
import Excepcion.horaException;
import Excepcion.mesException;
import Excepcion.modificarReservaCheckIn;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Multa;
import Modelo.ReservaHabitacion;
import com.sun.org.apache.xpath.internal.operations.Mult;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class BOCheckIn {

    private final BoHuesped BoHuesped;
    private final BOReserva BoReserva;
    private final BoHabitacion boHabitacion;
    private final BOCuentaPersonal boCuentaPersona;
    private final DAOMulta daoMulta;
    private ArrayList<ReservaHabitacion> listaReserva;

    public BOCheckIn() {
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

        listaReserva.stream().filter((reserva) -> (reserva.getEstado().equalsIgnoreCase("Prestado"))).filter((reserva) -> (reserva.getIdHuesped() == idHuesped)).forEachOrdered((reserva) -> {
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

    public void realizarCheckIn(Date fechaHoy, ReservaHabitacion reserva, int idHuesped) throws anoException, mesException, DiaException, horaException, DatosIncompletosException, modificarReservaCheckIn, GuardarCuentaPersonalException, MultaException {
// int idHuesped, int idReservaHabitacion, String estado, String valorApagar
        Calendar calLlegada = new GregorianCalendar();
        calLlegada.setTime(reserva.getFechaHoraCheckIn());
        int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
        int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
        int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

        Calendar calHoy = new GregorianCalendar();
        calHoy.setTime(fechaHoy);
        int yearFechaHoraReserva = calHoy.get(Calendar.YEAR);
        int monthFechaHoraReserva = calHoy.get(Calendar.MONTH);
        int dayFechaHoraReserva = calHoy.get(Calendar.DAY_OF_MONTH);

        int hora = calHoy.get(Calendar.HOUR_OF_DAY);

        int minutos = calHoy.get(Calendar.MINUTE);
        int segundos = calHoy.get(Calendar.SECOND);

        if (yearFechaHoraReserva == yearHoraFechaLlegada) {// si es el mismo año
            if (monthFechaHoraReserva == monthHoraFechaLlegada) {// si es el mismo mes

                if (dayHoraFechaLlegada == dayFechaHoraReserva) {

                    if (hora >= 14 && hora <= 16) {

                        if (BoReserva.modificarReserva("CheckIn", "Activo", reserva.getId())) {
                            boCuentaPersona.guardarCuentaPersonal(reserva.getIdHuesped(), reserva.getId(), "CheckIn", "0");

                        } else {
                            throw new modificarReservaCheckIn();
                        }

                    } else {
                        //   throw new horaException();
                        // aca va la multa  int id, int idHuesped, String cantidadPagar, String estado

                        Multa multa = new Multa(0, idHuesped, "0", "Multado");

                        if (daoMulta.guardarMulta(multa)) {
                            throw new MultaException();
                        }

                    }

                } else {
                    throw new DiaException();
                }

            } else {
                throw new mesException();
            }
        } else {
            throw new anoException();
        }

    }

}
