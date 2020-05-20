/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.CorreoException;
import Excepcion.DatosIncompletosException;
import Excepcion.TelefonoException;
import Modelo.Recepcionista;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAORecepcionista {

    /**
     * Método para agregar recepcionista
     *
     * @param recepcionista este parametro recibe un objeto de tipo
     * recepcionista
     * @return un boolean con la condicion si se genero throws CedulaException
     * si la cedula del huesped ya se encuentra existente
     * @throws Excepcion.CedulaException si la cedula del recepcionista ya se
     * encuentra existente
     * @throws CorreoException si el correo del recepcionista ya se encuentra
     * existente
     * @throws DatosIncompletosException si algunos de los datos son nulos
     * @throws TelefonoException si el telefono del recepcionista ya se
     * encuentra existente
     * @throws CedulaAdministradorException si la cedula pertenece a un administrador
     * @throws CedulaHuespedException si la cedula pertenece a un huesped
     */
    public boolean guardarRecepcionista(Recepcionista recepcionista) throws CedulaException, CorreoException, DatosIncompletosException, TelefonoException,CedulaAdministradorException, CedulaHuespedException;

    /**
     * Metodo para buscar recepcionista
     *
     * @param cedula este parametro recibe la cedula del recepcionista que se
     * desea buscar
     * @return un objeto tipo recepcionista
     */
    public Recepcionista buscarRecepcionista(String cedula);

    /**
     * Metodo para modificar recepcionista
     *
     * @param recepcionista este parametro recibe un objeto tipo recepcionista
     * @return un boolean con la condicion si se genero
     * @throws Excepcion.CedulaException si la cedula del recepcionista ya se
     * encuentra existente
     * @throws CorreoException si el correo del recepcionista ya se encuentra
     * existente
     * @throws DatosIncompletosException si algunos de los datos son nulos
     * @throws TelefonoException si el telefono del recepcionista ya se
     * encuentra existente
     */
    public boolean modificarRecepcionista(Recepcionista recepcionista) throws CedulaException, CorreoException, DatosIncompletosException, TelefonoException;

    /**
     * /**
     * Método para listar docentes
     *
     * @return una lista con todos los recepcionistas agregados
     */
    public ArrayList<Recepcionista> listarRecepcionista();

}
