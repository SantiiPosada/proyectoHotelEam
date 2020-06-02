/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DTO.DTOReservaActiva;
import Definiciones.IDAOHabitacion;
import Definiciones.IDAOMiCuenta;
import Definiciones.IDAOReserva;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import Modelo.ReservaHabitacion;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class BOfactura {

    private IDAOMiCuenta dao;
    private final DateFormat formato;
    private final IDAOHabitacion daoHabitacion;
    private final IDAOReserva daoReserva;

    public BOfactura() {
        dao = FactoryDAO.getFabrica().crearDAOMiCuenta();
        daoHabitacion = FactoryDAO.getFabrica().crearDAOHabitacIon();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        formato = DateFormat.getDateInstance();
    }
    public ArrayList<ReservaHabitacion> listareservas() {
        return daoReserva.listarReserva();
    }
     public DefaultTableModel listarElementosReservacionInactiva(int idHuesped) {
        ArrayList<ReservaHabitacion> lista = listareservas();
        ArrayList<Habitacion> listaHabitaciones = listaHabitacion();
        String nombreColumnas[] = {"Id Reserva", "Fecha Reservacion", "Habitacion", "Estado", "Estado Servicio"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 5:
                        return true;
                    default:
                        return false;
                }
            }
        };
        String habitaciones = "";
        for (ReservaHabitacion reserva : lista) {
            if (reserva.getEstado().equalsIgnoreCase("Prestado") && reserva.getIdHuesped() == idHuesped) {
                String fecha = formato.format(reserva.getFechaHoraReserva());
                for (Habitacion habitacion : listaHabitaciones) {

                    if (reserva.getIdHabitacion() == habitacion.getId()) {

                        habitaciones = habitacion.getNombre();

                        break;
                    }

                }
                modelo.addRow(new Object[]{reserva.getId(), fecha, habitaciones, reserva.getEstado(), reserva.getEstadoServicio()});
            }

        }

        return modelo;
    }
       public DefaultTableModel listarElementosReservacion(int idHuesped) {
        ArrayList<DTO.DTOReservaActiva> lista = listaReservas(idHuesped);
        ArrayList<Habitacion> listaHabitaciones = listaHabitacion();
        String nombreColumnas[] = {"Id Reserva", "Fecha Reservacion", "Habitacion", "Estado", "Valor"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 5:
                        return true;
                    default:
                        return false;
                }
            }
        };
        String habitaciones = "";
        for (DTO.DTOReservaActiva reserva : lista) {
            if (reserva.getEstado().equalsIgnoreCase("CheckIn")) {
                String fecha = formato.format(reserva.getFechareservacion());
                for (Habitacion habitacion : listaHabitaciones) {

                    if (reserva.getIdhabitacion() == habitacion.getId()) {

                        habitaciones = habitacion.getNombre();

                        break;
                    }

                }
                modelo.addRow(new Object[]{reserva.getIdreserva(), fecha, habitaciones, reserva.getEstado(), reserva.getValor()});
            }

        }

        return modelo;
    }
       
    public DTO.DTOReservaActiva buscarReserva(int idReserva, int idHuesped) {
        ArrayList<DTOReservaActiva> listasreserva = listaReservas(idHuesped);
        DTOReservaActiva reserva = new DTOReservaActiva();
        for (int i = 0; i < listasreserva.size(); i++) {
            if (listasreserva.get(i).getIdreserva() == idReserva) {
                if (listasreserva.get(i).getEstado().equalsIgnoreCase("CheckIn")) {
                    return listasreserva.get(i);
                }

            }
        }
        return reserva;
    }

    public ArrayList<DTO.DTOReservaActiva> listaReservas(int idHuesped) {

        return dao.BuscarReservasActivas(idHuesped);

    }

    public ArrayList<Habitacion> listaHabitacion() {
        return daoHabitacion.listarHabitacion();
    }

    public ArrayList<DTO.DTOProductosCuenta> listaProductos(int idReservacion) {
        return dao.BuscarProductosCuenta(idReservacion);
    }

    public DefaultTableModel listarElementosProductos(int idReservacion) {
        ArrayList<DTO.DTOProductosCuenta> lista = listaProductos(idReservacion);
        ArrayList<Habitacion> listaHabitaciones = listaHabitacion();
        String nombreColumnas[] = {"Id Producto", "Nombre", "Cantidad", "Valor Total"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 4:
                        return true;
                    default:
                        return false;
                }
            }
        };

        lista.forEach((producto) -> {
            int valortotal = Integer.parseInt(producto.getCantidad()) * Integer.parseInt(producto.getValortotal());
            modelo.addRow(new Object[]{producto.getIdProducto(), producto.getNombre(), producto.getCantidad(), valortotal});

        });

        return modelo;

    }

}
