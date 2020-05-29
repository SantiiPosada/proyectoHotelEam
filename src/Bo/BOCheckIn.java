/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHuesped;
import Excepcion.BuscarHuespedException;
import Excepcion.DatosIncompletosException;
import Fabrica.FactoryDAO;
import Modelo.Huesped;
import Modelo.ReservaHabitacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author santiago
 */
public class BOCheckIn {

    private final BoHuesped BoHuesped;
    private final BOReserva BoReserva;
    private ArrayList<ReservaHabitacion> listaReserva;

    public BOCheckIn() {
        BoHuesped = new BoHuesped();
        BoReserva = new BOReserva();
        listaReserva = new ArrayList<>();
    }

    private void listarReservas() {

        listaReserva = BoReserva.listarReserva();
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

    public DefaultComboBoxModel llenarComboBox(int idHuesped) {
        listarReservas();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        listaReserva.stream().filter((reserva) -> (reserva.getEstado().equalsIgnoreCase("Prestado"))).filter((reserva) -> (reserva.getIdHuesped() == idHuesped)).forEachOrdered((reserva) -> {
            modelo.addElement(reserva.getId());
        });
        return modelo;
    }

}
