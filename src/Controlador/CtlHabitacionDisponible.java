/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOHabitacionDisponible;
import Excepcion.DayException;
import Excepcion.FechaException;
import Excepcion.anoException;
import Excepcion.mesException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mateo
 */
public class CtlHabitacionDisponible {

    BOHabitacionDisponible bo;

    public CtlHabitacionDisponible() {
        bo = new BOHabitacionDisponible();
    }

    public void verificarFecha(Date fechaHoraReserva, Date horaFechaLlegada, Date fechaHoraSalida, int idHabitacion) throws anoException, mesException, FechaException, DayException {
        bo.verificarFecha(fechaHoraReserva, horaFechaLlegada, fechaHoraSalida, idHabitacion);
    }

    public DefaultComboBoxModel llenarComboBox() {
        return bo.llenarComboBox();
    }

}
