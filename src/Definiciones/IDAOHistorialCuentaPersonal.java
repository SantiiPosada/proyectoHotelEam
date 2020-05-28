/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Modelo.HistorialCuentaPersonal;

/**
 *
 * @author mateo
 */
public interface IDAOHistorialCuentaPersonal {

    /**
     * Metodo encargado de guardar historial de la cuenta personal del huesped
     *
     * @param historial recibe el historial
     * @return verdadero si guardo el huesped, falso si no
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean guardarHistorialCuentaPersonal(HistorialCuentaPersonal historial) throws DatosIncompletosException;

}
