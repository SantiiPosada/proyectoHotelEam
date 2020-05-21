/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHabitacion;
import Definiciones.IDAOReserva;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarReservaException;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import Modelo.ReservaHabitacion;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class BOReserva {

    private final IDAOReserva daoReserva;
    private final IDAOHabitacion daoHabitacion;
    private final DateFormat formato;

    public BOReserva() {
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        daoHabitacion = FactoryDAO.getFabrica().crearDAOHabitacIon();
        formato = DateFormat.getDateInstance();
    }

    public void guardarReserva(int idHuesped, int idHabitacion, Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida) throws GuardarReservaException, DatosIncompletosException {
        ReservaHabitacion reserva = new ReservaHabitacion(0, idHuesped, idHabitacion, fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida, fechaHoraLlegada, fechaHoraSalida, "Prestado", "inactivo");
        if (!daoReserva.guardarReserva(reserva)) {
            throw new GuardarReservaException();
        }
    }

    public ArrayList<Habitacion> listahabitaciones() {
        return daoHabitacion.listarHabitacion();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione habitacion")) {
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

}
