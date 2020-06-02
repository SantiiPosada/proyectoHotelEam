/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCheckOut;
import Excepcion.BuscarHabitacionException;
import Excepcion.BuscarHuespedException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.DiaException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.ModificarCuentaPersonalException;
import Excepcion.MultaException;
import Excepcion.anoException;
import Excepcion.horaException;
import Excepcion.mesException;
import Excepcion.modificarReservaCheckIn;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.ReservaHabitacion;
import java.awt.image.BufferedImage;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class CtlCheckOut {

    private final BOCheckOut bo;

    public CtlCheckOut() {
        bo = new BOCheckOut();
    }

    public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return bo.buscarHuesped(cedula);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public Habitacion buscarHabitacion(int idReserva) throws BuscarHabitacionException {
        return bo.buscarHabitacion(idReserva);
    }

    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        return bo.cargarImagenBufferedImage(bytes);
    }

    public ReservaHabitacion buscarReserva(int idReserva) {
        return bo.buscarReserva(idReserva);
    }

    public DefaultComboBoxModel llenarComboBox(int idHuesped) {
        return bo.llenarComboBox(idHuesped);
    }
        public void realizarCheckOut(Date fechaHoy, ReservaHabitacion reserva, int idHuesped) throws anoException, mesException, DiaException, horaException, DatosIncompletosException, modificarReservaCheckIn, GuardarCuentaPersonalException, ModificarCuentaPersonalException {
            bo.realizarCheckOut(fechaHoy, reserva, idHuesped);
        }

}
