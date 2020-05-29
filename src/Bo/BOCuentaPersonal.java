/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCuentaPersonal;
import Excepcion.BuscarCuentaPersonalException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarCuentaPersonalException;
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

    public void guardarCuentaPersonal(int idHuesped, int idReservaHabitacion, String estado, String valorApagar) throws DatosIncompletosException, GuardarCuentaPersonalException {
        CuentaPersonal cuentaPersona = new CuentaPersonal(0, idHuesped, idReservaHabitacion, estado, valorApagar);

        if (!dao.guardarCuentaPersonal(cuentaPersona)) {
            throw new GuardarCuentaPersonalException();
        }

    }

}
