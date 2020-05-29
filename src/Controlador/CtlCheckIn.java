/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCheckIn;
import Excepcion.BuscarHuespedException;
import Excepcion.DatosIncompletosException;
import Modelo.Huesped;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class CtlCheckIn {

    BOCheckIn bo;

    public CtlCheckIn() {
        bo = new BOCheckIn();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }
       public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException{
           return bo.buscarHuesped(cedula);
       }
       
        public DefaultComboBoxModel llenarComboBox(int idHuesped) {
            return bo.llenarComboBox(idHuesped);
        }
}
