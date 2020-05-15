/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.BuscarHuespedException;
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.DatosIncompletosException;
import Excepcion.TelefonoException;
import Modelo.Huesped;
import java.util.ArrayList;

/**
 *
 * @author santiago
 */
public interface IDAOHuesped {

    /**
     * Método encargado de guardar el huesped
     *
     * @param huesped recibe el huesped
     * @return vardadero si guardó el huesped falso si no
     * @throws CedulaException si la cedula del huesped ya se encuentra
     * existente
     * @throws CorreoException si el correo del huesped ya se encuentra
     * existente
     * @throws DatosIncompletosException si algunos de los datos son nulos
     * @throws TelefonoException si el telefono del huesped ya se encuentra
     * existente
     */
    public boolean guardarHuesped(Huesped huesped) throws CedulaException, CorreoException, DatosIncompletosException, TelefonoException;

    /**
     * Método encargado de buscar a un huesped
     *
     * @param cedula recibe la cedula del huesped al buscar
     * @return objeto con los datos del huesped
     */
    public Huesped buscarHuesped(String cedula) ;

    /**
     * Método encargado de modificar al huesped
     *
     * @param huesped objeto con todos los datos del huesped
     * @return verdadero si se modificó el huesped falso si no
     * @throws CedulaException si la cedula se encuentra registrada
     * @throws CorreoException si el correo se encuentra existente
     * @throws TelefonoException si el telefono se encuentra existente
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean modificarHuesped(Huesped huesped) throws CedulaException, CorreoException, TelefonoException, DatosIncompletosException;

    /**
     * Método para listar huesped
     *
     * @return una lista con los huesped registrados
     */
    public ArrayList<Huesped> listarHuesped();
}
