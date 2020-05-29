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

    /**
     * Metodó para la creación de un DAOHuesped
     *
     * @return Abstraccion de DAOHuesped
     */
    public IDAOHuesped crearDAOHuesped();

    /**
     * Metodó para la creación de un DAOLogIn
     *
     * @return Abstraccion de DAOLogIn
     */
    public IDAOLogIn crearDAOLogIn();

    /**
     * Metodó para la creación de un DAOAdministrador
     *
     * @return Abstraccion de DAOAdministrador
     */
    public IDAOAdministrador crearDAOAdministrador();

    /**
     * Metodo para la creacion de un DAOHabitacion
     *
     * @return Abstraccion de DAOHabitacion
     */
    public IDAOHabitacion crearDAOHabitacIon();

    /**
     * Metodo para la creacion de un DAOReserva
     *
     * @return Abstraccion de DAOReserva
     */
    public IDAOReserva crearDAOReserva();

    /**
     * Metodo para la creacion de un DAOCategoriaProductos
     *
     * @return Abstraccion de DAOCategoriaProductos
     */
    public IDAOCategoriaProductos crearDAOCategoriaProductos();

    /**
     * Metodo para la creacion de un DAOInventarioProductos
     *
     * @return Abstraccion de DAOInventarioProductos
     */
    public IDAOInventarioProductos crearDAOInventarioProductos();

    /**
     * Metodo para la creacion de un DAOHistorialCuentaPersonal
     *
     * @return Abstraccion de DAOHistorialCuentaPersonal
     */
    public IDAOHistorialCuentaPersonal crearDAOHistorialCuentaPersona();

    /**
     * Metodo para la creacion de un DAOMiCuenta
     *
     * @return Abstraccion de DAOMiCuenta
     */
    public IDAOMiCuenta crearDAOMiCuenta();
}
