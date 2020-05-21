/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.NombreHabitacionException;
import Modelo.Habitacion;

import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOHabitacion {

    /**
     * Metodo encargado de guardar habitacion
     *
     * @param habitacion recibe la habitacion
     * @return verdadero si guardo el huesped, falso si no
     * @throws NombreHabitacionException si el nombre de la habitacion ya se
     * encuentra registrada
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean guardarHabitacion(Habitacion habitacion) throws NombreHabitacionException, DatosIncompletosException;

    /**
     * Metodo encargado de buscar a una habitacion
     *
     * @param Nombre recibe el nombre de la habitacion al buscar
     * @return objeto con los datos de la habitacion
     */
    public Habitacion buscarHabitacion(String Nombre);

    /**
     * Metodo encargado de modificar la habitacion cuando modifica la imagen
     *
     * @param habitacion objeto con todos los datos del huesped
     * @return verdadero si se modifico la habitacion,falso si no
     * @throws NombreHabitacionException si el nombre de la habitacion ya se
     * encuentra registrada
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean modificarHabitacion(Habitacion habitacion) throws NombreHabitacionException, DatosIncompletosException;

    /**
     * Metodo encargado de modificar la habitacion cuando no modifica la imagen
     *
     * @param habitacion objeto con todos los datos del huesped
     * @return verdadero si se modifico la habitacion,falso si no
     * @throws NombreHabitacionException si el nombre de la habitacion ya se
     * encuentra registrada
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean modificarHabitacion2(Habitacion habitacion) throws NombreHabitacionException, DatosIncompletosException;

    /**
     * Metodo para listar la habitacion
     *
     * @return una lista con las habitaciones registrados
     */
    public ArrayList<Habitacion> listarHabitacion();

}
