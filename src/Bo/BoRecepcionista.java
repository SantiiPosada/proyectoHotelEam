/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAORecepcionista;
import Fabrica.FactoryDAO;

/**
 *
 * @author mateo
 */
public class BoRecepcionista {

    IDAORecepcionista daoRecepcionista;

    public BoRecepcionista() {
        daoRecepcionista = FactoryDAO.getFabrica().crearDAORecepcionista();
    }
    
}
