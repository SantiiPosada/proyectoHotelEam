/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHabitacion;
import Definiciones.IDAOReserva;
import Excepcion.BuscarHabitacionException;
import Excepcion.DatosIncompletosException;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import Modelo.ReservaHabitacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mateo
 */
public class BOEstadoReserva {

    private IDAOHabitacion daoHabitacion;
    private IDAOReserva daoReserva;

    public BOEstadoReserva() {
        daoHabitacion = FactoryDAO.getFabrica().crearDAOHabitacIon();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
    }

    public Habitacion buscarHabitacion(String nombre) throws DatosIncompletosException, BuscarHabitacionException {
        if (nombre == null) {
            throw new DatosIncompletosException();
        }
        Habitacion habitacion = daoHabitacion.buscarHabitacion(nombre);
        if (habitacion == null) {
            throw new BuscarHabitacionException();
        }
        return habitacion;
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
