/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

/**
 *
 * @author brian
 */
public interface IFabricaDAO {

    /**
     * Metodo para la creacion de un DAORecepcionista
     *
     * @return Abstraccion de DAORecepcionista
     */
    public IDAORecepcionista crearDAORecepcionista();

}
