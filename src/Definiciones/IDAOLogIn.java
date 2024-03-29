/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Modelo.Administrador;
import Modelo.Huesped;
import Modelo.Recepcionista;

/**
 *
 * @author santiago
 */
public interface IDAOLogIn {

    /**
     * Método encargado de ingresar\logear a un huesped
     *
     * @param cedula del huesped
     * @param contrasena del huesped
     * @return objeto con los datos del huesped
     */
    public Huesped LogInHuesped(String cedula, String contrasena);

    /**
     * Método encargado de ingresar\logear a un recepcionista
     *
     * @param cedula del recepcionista
     * @param contrasena del recepcionista
     * @return objeto con los datos del recepcionista
     */
    public Recepcionista LogInRecepcionista(String cedula, String contrasena);

    /**
     * Método encargado de ingresar\logear a un administrador
     *
     * @param cedula del administrador
     * @param contrasena del administrador
     * @return objeto con los datos del administrador
     */
    public Administrador LogInAdministrador(String cedula, String contrasena);

}
