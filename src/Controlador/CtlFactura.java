/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOfactura;
import Excepcion.BuscarHuespedException;
import Excepcion.DatosIncompletosException;
import Modelo.Huesped;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class CtlFactura {
    
    BOfactura bo;
    
    public CtlFactura(){
        bo=new BOfactura();
    }
    
    
    public DefaultTableModel listaElementosReservaInactiva(int idHuesped) {
        return bo.listarElementosReservacionInactiva(idHuesped);
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
      public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
          return bo.buscarHuesped(cedula);
      }
       public String obtenerDatoJtextFile(JTextField x) {
           return bo.obtenerDatoJtextFile(x);
       }
}
