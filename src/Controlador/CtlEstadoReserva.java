/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOEstadoReserva;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mateo
 */
public class CtlEstadoReserva {

    BOEstadoReserva bo;

    public CtlEstadoReserva() {
        bo = new BOEstadoReserva();
    }

    public DefaultComboBoxModel llenarComboBox() {
        return bo.llenarComboBox();
    }
}
