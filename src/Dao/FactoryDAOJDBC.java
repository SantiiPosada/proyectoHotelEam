/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOAdministrador;
import Definiciones.IDAOCategoriaProductos;
import Definiciones.IDAOHabitacion;
import Definiciones.IDAOHistorialCuentaPersonal;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOInventarioProductos;
import Definiciones.IDAOLogIn;
import Definiciones.IDAORecepcionista;
import Definiciones.IDAOReserva;
import Definiciones.IFabricaDAO;

/**
 *
 * @author mateo
 */
public class FactoryDAOJDBC implements IFabricaDAO {

    @Override
    public IDAORecepcionista crearDAORecepcionista() {
        return new DAORecepcionista();
    }

    @Override
    public IDAOHuesped crearDAOHuesped() {
        return new DaoHuesped();
    }

    @Override
    public IDAOLogIn crearDAOLogIn() {
        return new DAOLogIn();
    }

    @Override
    public IDAOAdministrador crearDAOAdministrador() {
        return new DAOAdministrador();
    }

    @Override
    public IDAOHabitacion crearDAOHabitacIon() {
        return new DAOHabitacion();
    }

    @Override
    public IDAOReserva crearDAOReserva() {
        return new DAOReserva();
    }

    @Override
    public IDAOCategoriaProductos crearDAOCategoriaProductos() {
        return new DAOCategoriaProductos();
    }

    @Override
    public IDAOInventarioProductos crearDAOInventarioProductos() {
        return new DAOInventarioProductos();
    }

    @Override
    public IDAOHistorialCuentaPersonal crearDAOHistorialCuentaPersona() {
        return new DAOHistorialCuentaPersonal();
    }

}
