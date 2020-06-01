/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Modelo.Multa;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOMulta {

    /**
     * Metodo para modificar el valor a pagar de la multa
     *
     * @param multa recibe el objeto de la multa
     * @return si guardo el huesped, falso si no
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean modificarMultasDTO(Multa multa) throws DatosIncompletosException;

    /**
     * Metodo encargado de consultar las multas de los huespedes
     *
     * @param cedula recibe la cedula del huesped
     * @return Arreglo de objeto con los datos de las multas
     */
    public ArrayList<DTO.DTOMulta> BuscarMultasDTO(String cedula);

}
