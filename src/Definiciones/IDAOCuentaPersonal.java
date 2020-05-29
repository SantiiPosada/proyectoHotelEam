/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Modelo.CuentaPersonal;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOCuentaPersonal {

    /**
     * Metodo para guardar una cuenta personal de un huesped
     *
     * @param cuentapersonal objeto tipo CuentaPersonal
     */
    public void guardarCuentaPersonal(CuentaPersonal cuentapersonal);

    /**
     * Método encargado de buscar a un administrador
     *
     * @param idReserva recibe el id de la reserva al buscar
     * @return objeto tipo CuentaPersonal
     */
    public CuentaPersonal buscarCuentaPersonal(int idReserva);

    /**
     * Metodo encargado de modificar a una cuanta personal
     *
     * @param cuentapersonal recibe el un objeto tipo Cuenta personal
     * @return verdadero si se modifico la habitacion,falso si no
     */
    public boolean modificarCuentaPersonal(CuentaPersonal cuentapersonal);

    /**
     ** Metodo para listar la cuenta personal
     *
     * @return una lista con las cuentas personales
     */
    public ArrayList<CuentaPersonal> listarCuentaPersonal();

}
