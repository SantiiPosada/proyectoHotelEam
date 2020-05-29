/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOMiCuenta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlMiCuenta {

    BOMiCuenta bo;

    public CtlMiCuenta() {
        bo = new BOMiCuenta();
    }

    public DefaultTableModel listaElementosReserva(int idhuesped) {
        return bo.listarElementosReservacion(idhuesped);
    }

    public DTO.DTOReservaActiva buscarReservaActiva(int idReserva, int idHuesped) {
        return bo.buscarReserva(idReserva, idHuesped);
    }

    public DefaultTableModel listaElementosProductos(int idReserva) {
        return bo.listarElementosProductos(idReserva);
    }
}
