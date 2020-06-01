/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCuentaPersonal;
import Definiciones.IDAOHabitacion;
import Definiciones.IDAOHistorialHospedaje;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOMiCuenta;
import Definiciones.IDAOReserva;
import Fabrica.FactoryDAO;
import Modelo.CuentaPersonal;
import Modelo.Habitacion;
import Modelo.Huesped;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOHistorialHospedaje {

    private IDAOHistorialHospedaje dao;
    private final DateFormat formato;
    private final IDAOHabitacion daoHabitacion;
    private final IDAOReserva daoReserva;
    private IDAOMiCuenta daoMicuenta;
    private IDAOHuesped daoHuesped;
    private IDAOCuentaPersonal daoCuentaPersonal;

    public BOHistorialHospedaje() {
        dao = FactoryDAO.getFabrica().crearDAOHistorialHospedaje();
        daoHabitacion = FactoryDAO.getFabrica().crearDAOHabitacIon();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        daoMicuenta = FactoryDAO.getFabrica().crearDAOMiCuenta();
        daoHuesped = FactoryDAO.getFabrica().crearDAOHuesped();
        daoCuentaPersonal = FactoryDAO.getFabrica().crearDAOCuentaPersonal();
        formato = DateFormat.getDateInstance();
    }

    public ArrayList<CuentaPersonal> listaCuentaPersonal() {

        return daoCuentaPersonal.listarCuentaPersonal();

    }

    public ArrayList<DTO.DTOReservaActiva> listaReservas(int idHuesped) {

        return daoMicuenta.BuscarReservasActivas(idHuesped);

    }

    public ArrayList<Huesped> listaHuesped() {
        return daoHuesped.listarHuesped();
    }

    public ArrayList<Habitacion> listaHabitacion() {
        return daoHabitacion.listarHabitacion();
    }

    public ArrayList<DTO.DTOProductosCuenta> listaProductos(int idReservacion) {
        return daoMicuenta.BuscarProductosCuenta(idReservacion);
    }

    public ArrayList<DTO.DTOHistorialHospedaje> listaHistorial() {
        return dao.HistorialHospedaje();
    }

    public DefaultTableModel listarElementosHistorial() {
        ArrayList<DTO.DTOHistorialHospedaje> lista = listaHistorial();
        ArrayList<Habitacion> listaHabitaciones = listaHabitacion();
        ArrayList<Huesped> listaHuesped = listaHuesped();
        ArrayList<CuentaPersonal> listaCuentaPersonal = listaCuentaPersonal();
        String nombreColumnas[] = {"Id Reserva", "Id Habitacion", "Nombre habitacion", "Valor Por Noche", "Fecha Check-in", "Fecha Check-out", "Estado Reserva", "Cedula Huesped", "Nombre Huesped", "Valor Total A Pagar"};
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
        String habitaciones = "";
        String valornoche = "";
        for (DTO.DTOHistorialHospedaje historial : lista) {
            String fechacheckin = formato.format(historial.getFechaCheckin());
            String fechacheckout = formato.format(historial.getFechaCheckout());
            for (Habitacion habitacion : listaHabitaciones) {

                if (historial.getIdHabitacion() == habitacion.getId()) {

                    habitaciones = habitacion.getNombre();
                    valornoche = habitacion.getValorPorNoche();
                    break;
                }

            }
            String nombre = "";
            String cedula = "";
            for (Huesped huesped : listaHuesped) {

                if (historial.getIdHuesped() == huesped.getId()) {

                    cedula = huesped.getCedula();
                    nombre = huesped.getNombrecompleto();
                    break;
                }

            }
            String valortotal = "";
            for (CuentaPersonal cuentapersonal : listaCuentaPersonal) {
                if (cuentapersonal.getIdReservaHabitacion() == historial.getIdReserva()) {
                    valortotal = cuentapersonal.getValorApagar();
                    break;
                }
            }
            modelo.addRow(new Object[]{historial.getIdReserva(), historial.getIdHabitacion(), habitaciones, valornoche, fechacheckin, fechacheckout, historial.getEstadoReserva(), cedula, nombre, valortotal});

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
