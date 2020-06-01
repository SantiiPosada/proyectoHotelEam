/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOMultas;
import Excepcion.BuscarMultasException;
import Excepcion.DatosIncompletosException;
import Excepcion.MultaIdReservaException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlMultas {

    BOMultas bo;

    public CtlMultas() {

        bo = new BOMultas();
    }

    public DTO.DTOMulta buscarMultaDTO(int id, String cedula) throws DatosIncompletosException, BuscarMultasException {
        return bo.buscarMultaDTO(id, cedula);
    }

    public DefaultTableModel listarElementoMultaDTO(String cedula) throws DatosIncompletosException, BuscarMultasException {
        return bo.listarElementosMultasDTO(cedula);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public String valorMultaDTO(String idReserva) throws MultaIdReservaException {
        return bo.valorMultaDTO(idReserva);
    }
}
