/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCheckOut;
import Excepcion.BuscarHuespedException;
import Excepcion.DatosIncompletosException;
import Modelo.Huesped;
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

}
