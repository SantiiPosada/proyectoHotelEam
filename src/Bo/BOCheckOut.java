/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Excepcion.BuscarHuespedException;
import Excepcion.DatosIncompletosException;
import Modelo.Huesped;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class BOCheckOut {

    private final BoHuesped BoHuesped;

    public BOCheckOut() {
        BoHuesped = new BoHuesped();
    }

    public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return BoHuesped.buscar(cedula);
    }
    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }
    
}
