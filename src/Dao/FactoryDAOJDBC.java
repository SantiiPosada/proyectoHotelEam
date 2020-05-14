/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAORecepcionista;
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

}
