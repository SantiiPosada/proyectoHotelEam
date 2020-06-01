/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.DAOHabitacion;
import Dao.DAOReserva;
import Dao.DAOcompraHabitacion;
import Dao.DaoHuesped;
import Definiciones.IDAOCompraHabitacion;
import Excepcion.BuscarHabitacionException;
import Excepcion.BuscarHuespedException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.DayException;
import Excepcion.FechaException;
import Excepcion.GuardarReservaException;
import Excepcion.ReservaActivaException;
import Excepcion.UsuarioMultadoException;
import Excepcion.anoException;
import Excepcion.mesException;
import Modelo.CompraHabitacion;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.ReservaHabitacion;
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
public class BOCompraHabitacion {

    private final IDAOCompraHabitacion daoCompraHabitacion;
    private final DAOHabitacion daoHabitacion;
    private final DAOReserva daoReserva;
    private final DaoHuesped daoHuesped;

    public BOCompraHabitacion() {
        daoCompraHabitacion = new DAOcompraHabitacion();
        daoHuesped = new DaoHuesped();
        daoHabitacion = new DAOHabitacion();
        daoReserva = new DAOReserva();
    }

    public Huesped buscar(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return daoHuesped.buscarHuesped(cedula);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public DefaultComboBoxModel llenarComboBox() {
        ArrayList<Habitacion> listarhabitaciones = listahabitaciones();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        for (int i = 0; i < listarhabitaciones.size(); i++) {
            if (listarhabitaciones.get(i).getEstado().equalsIgnoreCase("Disponible")) {
                modelo.addElement(listarhabitaciones.get(i).getNombre());
            }

        }
        return modelo;
    }

    private ArrayList<Habitacion> listahabitaciones() {
        return daoHabitacion.listarHabitacion();
    }

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

    private void validarDatos(Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida) throws DatosIncompletosException {
        if (fechaHoraReserva == null || fechaHoraLlegada == null || fechaHoraSalida == null) {
            throw new DatosIncompletosException();
        }
    }

    private String verificarTipoUsuario(int idHuesped) {
        ArrayList<Huesped> ListaHuesped = daoHuesped.listarHuesped();

        for (Huesped huesped : ListaHuesped) {
            if (huesped.getId() == idHuesped) {
                return huesped.getTipo();
            }
        }

        return null;

    }

    public ArrayList<CompraHabitacion> listarCompras() {
        return daoCompraHabitacion.listarCompra();
    }

    public ArrayList<ReservaHabitacion> listarReserva() {
        return daoReserva.listarReserva();
    }

    private void verificarSiTieneReserva(int idHuesped, int idHabitacion) throws UsuarioMultadoException, ReservaActivaException {

        ArrayList<ReservaHabitacion> lista = listarReserva();//todas las reservas
        if (!lista.isEmpty()) {
            for (ReservaHabitacion reservaHabitacion : lista) {
                if (reservaHabitacion.getIdHuesped() == idHuesped && reservaHabitacion.getIdHabitacion() == idHabitacion) {
                    if (reservaHabitacion.getEstado().equalsIgnoreCase("Multado")) {
                        throw new UsuarioMultadoException();
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("Prestado")) {
                        throw new ReservaActivaException();
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("CheckIn")) {
                        throw new ReservaActivaException();
                    }
                }
            }
        }

    }

    private void verificarSiTieneDosReserva(int idHuesped, int idHabitacion) throws UsuarioMultadoException, ReservaActivaException {

        ArrayList<ReservaHabitacion> lista = listarReserva();//todas las reservas
        int contador = 0;
        if (!lista.isEmpty()) {
            for (ReservaHabitacion reservaHabitacion : lista) {
                if (reservaHabitacion.getIdHuesped() == idHuesped && reservaHabitacion.getIdHabitacion() == idHabitacion) {
                    if (reservaHabitacion.getEstado().equalsIgnoreCase("Multado")) {
                        throw new UsuarioMultadoException();
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("Prestado")) {
                        contador++;
                        if (contador == 2) {
                            throw new ReservaActivaException();
                        }
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("CheckIn")) {
                        contador++;
                        if (contador == 2) {
                            throw new ReservaActivaException();
                        }
                    }
                }

            }
        }

    }

    public void guardarCompra(int idHuesped, int idHabitacion, Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida) throws GuardarReservaException, DatosIncompletosException, anoException, mesException, FechaException, DayException, UsuarioMultadoException, ReservaActivaException {
        validarDatos(fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida);
        fechaHoraLlegada.setHours(0);
        fechaHoraLlegada.setMinutes(0);
        fechaHoraLlegada.setSeconds(0);
        fechaHoraSalida.setHours(0);
        fechaHoraSalida.setMinutes(0);
        fechaHoraSalida.setSeconds(0);
        if (verificarTipoUsuario(idHuesped).equalsIgnoreCase("regular")) {
            verificarSiTieneReserva(idHuesped, idHabitacion);
        } else {
            verificarSiTieneDosReserva(idHuesped, idHabitacion);

        }
        verificarFecha(fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida, idHabitacion);
        CompraHabitacion compra = new CompraHabitacion(0, idHuesped, idHabitacion, fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida, fechaHoraLlegada, fechaHoraSalida, "Prestado", "inactivo");
        if (!daoCompraHabitacion.guardarCompra(compra)) {
            throw new GuardarReservaException();
        }
    }

    private void verificarFecha(Date fechaHoraReserva, Date horaFechaLlegada, Date fechaHoraSalida, int idHabitacion) throws anoException, mesException, FechaException, DayException {
        Calendar calLlegada = new GregorianCalendar();
        calLlegada.setTime(horaFechaLlegada);
        int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
        int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
        int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

        Calendar calSalida = new GregorianCalendar();
        calSalida.setTime(fechaHoraSalida);
        int yearFechaHoraSalida = calSalida.get(Calendar.YEAR);
        int monthFechaHoraSalida = calSalida.get(Calendar.MONTH);
        int dayFechaHoraSalida = calSalida.get(Calendar.DAY_OF_MONTH);

        Calendar calHoy = new GregorianCalendar();
        calHoy.setTime(fechaHoraReserva);
        int yearFechaHoraReserva = calHoy.get(Calendar.YEAR);
        int monthFechaHoraReserva = calHoy.get(Calendar.MONTH);
        int dayFechaHoraReserva = calHoy.get(Calendar.DAY_OF_MONTH);

        if (yearFechaHoraReserva == yearHoraFechaLlegada && yearFechaHoraReserva == yearFechaHoraSalida) {// si es el mismo año
            if (monthFechaHoraReserva == monthHoraFechaLlegada && monthFechaHoraReserva == monthFechaHoraSalida) {// si es el mismo mes

                if (dayFechaHoraReserva == dayHoraFechaLlegada) {
                    throw new DayException();
                } else if (dayFechaHoraSalida <= dayHoraFechaLlegada) {
                    throw new DayException();
                } else {
                    ArrayList<ReservaHabitacion> lista = listarReserva();//todas las reservas
                    ArrayList<CompraHabitacion> listaCompraHabitacion = listarCompras();
                    if (!lista.isEmpty()) {
                        for (ReservaHabitacion reservaHabitacion : lista) {
                            if (idHabitacion == reservaHabitacion.getIdHabitacion()) {

                                if (reservaHabitacion.getEstado().equals("Prestado") || reservaHabitacion.getEstado().equalsIgnoreCase("CheckIn")) {

                                    Calendar calCheckIn = new GregorianCalendar();
                                    calCheckIn.setTime(reservaHabitacion.getFechaHoraCheckIn());
                                    int yearCheckIn = calCheckIn.get(Calendar.YEAR);
                                    int monthCheckIn = calCheckIn.get(Calendar.MONTH);
                                    int dayCheckIn = calCheckIn.get(Calendar.DAY_OF_MONTH);

                                    Calendar calCheckOut = new GregorianCalendar();
                                    calCheckOut.setTime(reservaHabitacion.getFechaHoraCheckOut());
                                    int yearCheckOut = calCheckOut.get(Calendar.YEAR);
                                    int monthCheckOut = calCheckOut.get(Calendar.MONTH);
                                    int dayCheckOut = calCheckOut.get(Calendar.DAY_OF_MONTH);

                                    if (yearFechaHoraReserva == yearCheckIn && yearFechaHoraReserva == yearCheckOut) {// si es el mismo año
                                        if (monthFechaHoraReserva == monthCheckIn && monthFechaHoraReserva == monthCheckOut) {// si es el mismo mes

                                            if (dayHoraFechaLlegada >= dayCheckOut) {

                                            } else {
                                                throw new FechaException();
                                            }

                                        }

                                    }
                                }
                            }

                        }

                        if (!listaCompraHabitacion.isEmpty()) {
                            for (CompraHabitacion compraHabitacion : listaCompraHabitacion) {
                                if (idHabitacion == compraHabitacion.getIdHabitacion()) {

                                    if (compraHabitacion.getEstado().equals("Prestado") || compraHabitacion.getEstado().equalsIgnoreCase("CheckIn")) {

                                        Calendar calCheckIn = new GregorianCalendar();
                                        calCheckIn.setTime(compraHabitacion.getFechaHoraCheckIn());
                                        int yearCheckIn = calCheckIn.get(Calendar.YEAR);
                                        int monthCheckIn = calCheckIn.get(Calendar.MONTH);
                                        int dayCheckIn = calCheckIn.get(Calendar.DAY_OF_MONTH);

                                        Calendar calCheckOut = new GregorianCalendar();
                                        calCheckOut.setTime(compraHabitacion.getFechaHoraCheckOut());
                                        int yearCheckOut = calCheckOut.get(Calendar.YEAR);
                                        int monthCheckOut = calCheckOut.get(Calendar.MONTH);
                                        int dayCheckOut = calCheckOut.get(Calendar.DAY_OF_MONTH);

                                        if (yearFechaHoraReserva == yearCheckIn && yearFechaHoraReserva == yearCheckOut) {// si es el mismo año
                                            if (monthFechaHoraReserva == monthCheckIn && monthFechaHoraReserva == monthCheckOut) {// si es el mismo mes

                                                if (dayHoraFechaLlegada >= dayCheckOut) {

                                                } else {
                                                    throw new FechaException();
                                                }

                                            }

                                        }
                                    }
                                }

                            }
                        }

                    }

                }

            } else {
                throw new mesException();
            }
        } else {
            throw new anoException();
        }

    }

}
