/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DTO.DTOMulta;
import Definiciones.IDAOHabitacion;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOMulta;
import Definiciones.IDAOReserva;
import Excepcion.BuscarMultasException;
import Excepcion.DatosIncompletosException;
import Excepcion.MultaIdReservaException;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.ReservaHabitacion;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOMultas {

    private IDAOMulta dao;
    private final DateFormat formato;
    private final IDAOHuesped daoHuesped;
    private final IDAOReserva daoReserva;
    private final IDAOHabitacion daoHabitacion;

    public BOMultas() {
        dao = FactoryDAO.getFabrica().crearDAOMulta();
        daoHuesped = FactoryDAO.getFabrica().crearDAOHuesped();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        daoHabitacion = FactoryDAO.getFabrica().crearDAOHabitacIon();
        formato = DateFormat.getDateInstance();
    }

    public ArrayList<DTO.DTOMulta> listaMultasDTO(String cedula) throws DatosIncompletosException, BuscarMultasException {
        if (cedula == null) {
            throw new DatosIncompletosException();
        }
        ArrayList<DTO.DTOMulta> lista = dao.BuscarMultasDTO(cedula);
        if (lista == null) {
            throw new BuscarMultasException();
        }
        return lista;
    }

    public ArrayList<ReservaHabitacion> listaReservas() {
        return daoReserva.listarReserva();
    }

    public ArrayList<Habitacion> listaHabitacion() {
        return daoHabitacion.listarHabitacion();
    }

    public DTO.DTOMulta buscarMultaDTO(int id, String cedula) throws DatosIncompletosException, BuscarMultasException {
        ArrayList<DTO.DTOMulta> listaMulta = listaMultasDTO(cedula);
        DTO.DTOMulta multa = new DTOMulta();
        for (int i = 0; i < listaMulta.size(); i++) {
            if (listaMulta.get(i).getEstadomulta().equalsIgnoreCase("Sin Pagar") && listaMulta.get(i).getEstadoreservacion().equalsIgnoreCase("Multado")) {
                if (listaMulta.get(i).getCedula().equalsIgnoreCase(cedula) && listaMulta.get(i).getId() == id) {
                    return listaMulta.get(i);
                }
            }
        }
        return multa;
    }

    public DefaultTableModel listarElementosMultasDTO(String cedula) throws DatosIncompletosException, BuscarMultasException {
        ArrayList<DTO.DTOMulta> lista = listaMultasDTO(cedula);

        String nombreColumnas[] = {"Id", "Cedula", "Nombre Huesped", "Habitacion", "Estado Reserva", "Fecha Reserva", "Check-in", "Check-out", "Cantidad a Pagar", "Estado Multa"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 10:
                        return true;
                    default:
                        return false;
                }
            }
        };

        for (DTO.DTOMulta multa : lista) {
            if (multa.getEstadomulta().equalsIgnoreCase("Sin Pagar") && multa.getEstadoreservacion().equalsIgnoreCase("Multado")) {
                String fechacheckin = formato.format(multa.getFechaHoraCheckIn());
                String fechacheckout = formato.format(multa.getFechaHoraCheckOut());
                String fechareservacion = formato.format(multa.getFechaHoraReserva());
                modelo.addRow(new Object[]{multa.getId(), multa.getCedula(), multa.getNombrehuesped(), multa.getNombreHabitacion(), multa.getEstadoreservacion(), fechareservacion, fechacheckin, fechacheckout, multa.getCantidadPagar(), multa.getEstadomulta()});
            }

        }

        return modelo;
    }

    public String valorMultaDTO(String idReserva) throws MultaIdReservaException {
        if (idReserva.equalsIgnoreCase(null)) {
            throw new MultaIdReservaException();
        }
        int idreserva = Integer.parseInt(idReserva);
        ArrayList<ReservaHabitacion> listareserva = listaReservas();
        ArrayList<Habitacion> listahabitacion = listaHabitacion();
        for (int i = 0; i < listareserva.size(); i++) {
            if (listareserva.get(i).getId() == idreserva) {
                Calendar calLlegada = new GregorianCalendar();
                calLlegada.setTime(listareserva.get(i).getFechaHoraCheckIn());
                int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
                int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
                int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

                Calendar calSalida = new GregorianCalendar();
                calSalida.setTime(listareserva.get(i).getFechaHoraCheckOut());
                int yearFechaHoraSalida = calSalida.get(Calendar.YEAR);
                int monthFechaHoraSalida = calSalida.get(Calendar.MONTH);
                int dayFechaHoraSalida = calSalida.get(Calendar.DAY_OF_MONTH);

                int cantidadnoches = dayFechaHoraSalida - dayHoraFechaLlegada;
                int valornoche = 0;
                for (int j = 0; j < listahabitacion.size(); j++) {
                    if (listahabitacion.get(j).getId() == listareserva.get(i).getIdHabitacion()) {
                        valornoche = Integer.parseInt(listahabitacion.get(j).getValorPorNoche());
                        break;
                    }
                }
                int valortotal = cantidadnoches * valornoche;
                return valortotal + "";
            }
        }
        return null;

    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }
}
