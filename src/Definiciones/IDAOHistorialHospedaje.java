/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOHistorialHospedaje {

    /**
     * Metodo para buscar el historialHospedaje
     *
     * @return Arreglo de objetos de tipo DTOHistorialHospedaje
     */
    public ArrayList<DTO.DTOHistorialHospedaje> HistorialHospedaje();
}
