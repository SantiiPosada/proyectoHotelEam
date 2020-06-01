/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DTO.DTOHistorialHospedaje;
import Definiciones.IDAOCuentaPersonal;
import Definiciones.IDAOHabitacion;
import Definiciones.IDAOHistorialHospedaje;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOMiCuenta;
import Definiciones.IDAOReserva;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Fabrica.FactoryDAO;
import Modelo.CuentaPersonal;
import Modelo.Habitacion;
import Modelo.Huesped;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextField;
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
//modificar

    public ArrayList<DTO.DTOProductosCuenta> listaProductos(int idReservacion) {
        return daoMicuenta.BuscarProductosCuenta(idReservacion);
    }

    public ArrayList<DTO.DTOHistorialHospedaje> listaHistorial() {
        return dao.HistorialHospedaje();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
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

    public DefaultTableModel listarElementosReservacion(int idReservacion, int idHuesped) {
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
            if (reserva.getIdreserva() == idReservacion) {
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

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion == null) {
            throw new DatosIncompletosException();
        }

        ArrayList<DTOHistorialHospedaje> lista = listaHistorial();
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

        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();

            case "Nombre habitacion":
                lista.forEach((historial) -> {
                    if (historial.getNombreHabitacion().equalsIgnoreCase(accion)) {
                        String fechacheckin = formato.format(historial.getFechaCheckin());
                        String fechacheckout = formato.format(historial.getFechaCheckout());
                        String habitaciones = "";
                        String valornoche = "";
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

                });
                return modelo;

            case "Fecha Check-in":
                lista.forEach((historial) -> {
                    if (historial.getFechaCheckin() == convertirDeDatetimeUtilaDate(accion)) {
                        String fechacheckin = formato.format(historial.getFechaCheckin());
                        String fechacheckout = formato.format(historial.getFechaCheckout());
                        String habitaciones = "";
                        String valornoche = "";
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

                });
                return modelo;

            case "Fecha Check-out":
                lista.forEach((historial) -> {
                    if (historial.getFechaCheckout() == convertirDeDatetimeUtilaDate(accion)) {
                        String fechacheckin = formato.format(historial.getFechaCheckin());
                        String fechacheckout = formato.format(historial.getFechaCheckout());
                        String habitaciones = "";
                        String valornoche = "";
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

                });
                return modelo;

            case "Cedula Huesped":
                lista.forEach((historial) -> {
                    String nombre = "";
                    String cedula = "";
                    for (Huesped huesped : listaHuesped) {

                        if (historial.getIdHuesped() == huesped.getId()) {

                            cedula = huesped.getCedula();
                            nombre = huesped.getNombrecompleto();
                            break;
                        }

                    }
                    if (cedula.equalsIgnoreCase(accion)) {
                        String fechacheckin = formato.format(historial.getFechaCheckin());
                        String fechacheckout = formato.format(historial.getFechaCheckout());
                        String habitaciones = "";
                        String valornoche = "";
                        for (Habitacion habitacion : listaHabitaciones) {

                            if (historial.getIdHabitacion() == habitacion.getId()) {

                                habitaciones = habitacion.getNombre();
                                valornoche = habitacion.getValorPorNoche();
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

                });
                return modelo;

            default:
                break;
        }
        return modelo;

    }

    /**
     * Metodo convertir el datetime de la base de datos a tipo date
     *
     * @param datetime objeto de la fechatime de la base dato
     * @return objeto tipo dato
     */
    private Date convertirDeDatetimeUtilaDate(String datetime) {
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//      dd/MM/yyyy
        try {
            Date date6 = formatter6.parse(datetime);
            return date6;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public String deDateaString(Date uDate) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(uDate);

        return currentTime;
    }
}
