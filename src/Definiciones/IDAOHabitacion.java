/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.ImagenException;
import Excepcion.NombreHabitacionException;
import Excepcion.NombreImagenException;
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
     * @throws Excepcion.NombreHabitacionException si el nombre de la habitacion
     * ya se encuentra registrada
     * @throws Excepcion.NombreImagenException si el nombre de la imagen ya se
     * encuentra registrada
     * @throws Excepcion.ImagenException si la imagen ya se encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean guardarHabitacion(Habitacion habitacion) throws NombreHabitacionException, NombreImagenException, ImagenException, DatosIncompletosException;

    /**
     * Metodo encargado de buscar a una habitacion
     *
     * @param Nombre recube el nombre de la habitacion al buscar
     * @return objeto con los datos del huesped
     */
    public Habitacion buscarHabitacion(String Nombre);

    /**
     * Metodo encargado de modificar la habitacion
     *
     * @param habitacion objeto con todos los datos del huesped
     * @return verdadero si se modifico la habitacion,falso si no
     * @throws Excepcion.NombreHabitacionException si el nombre de la habitacion
     * ya se encuentra registrada
     * @throws Excepcion.NombreImagenException si el nombre de la imagen ya se
     * encuentra registrada
     * @throws Excepcion.ImagenException si la imagen ya se encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean modificarHabitacion(Habitacion habitacion) throws NombreHabitacionException, NombreImagenException, ImagenException, DatosIncompletosException;

    /**
     * Metodo para listar huesped
     *
     * @return una lista con las habitaciones registrados
     */
    public ArrayList<Habitacion> listarHabitacion();

}
