/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import DTO.DTOProductosCuenta;
import DTO.DTOProductosHuesped;
import DTO.DTOReservaActiva;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOMiCuenta {

    /**
     * Metodo encargado de consultar los productos del huesped
     *
     * @param idReservacion recibe el id de la reservacion del huesped
     * @return Arreglo de objeto con los datos de los productos
     */
    public ArrayList<DTOProductosCuenta> BuscarProductosCuenta(int idReservacion);

    /**
     * Metodo encargado de consultar los productos del huesped
     *
     * @param idReservacion recibe el id de la reservacion del huesped
     * @param idHuesped recibe el id del huesped
     * @return Arreglo de objeto con los datos de los productos
     */
    public ArrayList<DTOProductosHuesped> BuscarProductosHuesped(int idReservacion, int idHuesped);

    /**
     * Metodo encargado de consultar las reservas activas del huesped
     *
     * @param idHuesped recibe el id del huesped
     * @return Arreglo de objeto con los datos de las reservas activas
     */
    public ArrayList<DTOReservaActiva> BuscarReservasActivas(int idHuesped);

}
