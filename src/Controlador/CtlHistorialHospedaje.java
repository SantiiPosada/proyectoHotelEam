/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOHistorialHospedaje;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlHistorialHospedaje {

    BOHistorialHospedaje bo;

    public CtlHistorialHospedaje() {
        bo = new BOHistorialHospedaje();
    }

    public DefaultTableModel listarElementosHistorial() {
        return bo.listarElementosHistorial();
    }
}
