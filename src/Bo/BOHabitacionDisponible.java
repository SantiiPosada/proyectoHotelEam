/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHabitacion;
import Definiciones.IDAOReserva;
import Excepcion.DatosIncompletosException;
import Excepcion.DayException;
import Excepcion.FechaException;
import Excepcion.anoException;
import Excepcion.mesException;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import Modelo.ReservaHabitacion;
import com.itextpdf.text.pdf.languages.ArabicLigaturizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mateo
 */
public class BOHabitacionDisponible {
    
    private IDAOHabitacion daoHabitacion;
    private IDAOReserva daoReserva;
    
    public BOHabitacionDisponible() {
        daoHabitacion = FactoryDAO.getFabrica().crearDAOHabitacIon();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
    }
    
    public void validarDatos(Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida) throws DatosIncompletosException {
        if (fechaHoraReserva == null || fechaHoraLlegada == null || fechaHoraSalida == null) {
            throw new DatosIncompletosException();
        }
    }
    
    public void verificarFecha(Date fechaHoraReserva, Date horaFechaLlegada, Date fechaHoraSalida, int idHabitacion) throws anoException, mesException, FechaException, DayException, DatosIncompletosException {
        validarDatos(fechaHoraReserva, fechaHoraSalida, fechaHoraSalida);
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
                    ArrayList<ReservaHabitacion> lista = listaReservas();//todas las reservas
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
                        
                    }
                    
                }
                
            } else {
                throw new mesException();
            }
        } else {
            throw new anoException();
        }
        
    }
    
    public ArrayList<Habitacion> listaHabitaciones() {
        return daoHabitacion.listarHabitacion();
    }
    
    private ArrayList<ReservaHabitacion> listaReservas() {
        return daoReserva.listarReserva();
    }
    
    public DefaultComboBoxModel llenarComboBox() {
        ArrayList<Habitacion> listarhabitaciones = listaHabitaciones();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        for (int i = 0; i < listarhabitaciones.size(); i++) {
            if (listarhabitaciones.get(i).getEstado().equalsIgnoreCase("Disponible")) {
                modelo.addElement(listarhabitaciones.get(i).getNombre());
            }
            
        }
        return modelo;
    }
}
