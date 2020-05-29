/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCuentaPersonal;
import Excepcion.BuscarCuentaPersonalException;
import Excepcion.DatosIncompletosException;
import Fabrica.FactoryDAO;
import Modelo.CuentaPersonal;

/**
 *
 * @author mateo
 */
public class BOCuentaPersonal {

    private final IDAOCuentaPersonal dao;

    public BOCuentaPersonal() {
        dao = FactoryDAO.getFabrica().crearDAOCuentaPersonal();
    }

    public CuentaPersonal buscarCuentaPersonal(int idReserva) throws DatosIncompletosException, BuscarCuentaPersonalException {

        if (idReserva == 0) {
            throw new DatosIncompletosException();
        }
        CuentaPersonal cuenta = dao.buscarCuentaPersonal(idReserva);
        if (cuenta == null) {
            throw new BuscarCuentaPersonalException();
        }

        return cuenta;
    }
}
