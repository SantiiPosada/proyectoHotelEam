/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Modelo.ReservaHabitacion;

/**
 *
 * @author mateo
 */
public interface IDAOReserva {

    /**
     * Metodo encargado de guardar Reserva
     *
     * @param reserva recibe la reservahabitacion
     * @return verdadero si guardo Reserva,falso si no
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean guardarReserva(ReservaHabitacion reserva) throws DatosIncompletosException;

}
