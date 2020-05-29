/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOCuentaPersonal;
import Modelo.CuentaPersonal;
import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class DAOCuentaPersonal implements IDAOCuentaPersonal {

    @Override
    public void guardarCuentaPersonal(CuentaPersonal cuentapersonal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CuentaPersonal buscarCuentaPersonal(int idReserva) {
        CuentaPersonal cuenta = new CuentaPersonal();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idHuesped,idReservaHabitacion,idCompraHabitacion,estado,valorApagar FROM cuentaPersonal where idReservaHabitacion=?");
            pstmt.setInt(1, idReserva);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                cuenta.setId(respuesta.getInt("id"));
                cuenta.setIdHuesped(respuesta.getInt("idHuesped"));
                cuenta.setIdReservaHabitacion(respuesta.getInt("idReservaHabitacion"));
                cuenta.setIdCompraHabitacion(respuesta.getInt("idCompraHabitacion"));
                cuenta.setEstado(respuesta.getString("estado"));
                cuenta.setValorApagar(respuesta.getString("valorApagar"));

                return cuenta;
            }
        } catch (SQLException ex) {
            cuenta = null;

        }
        return null;
    }

    @Override
    public boolean modificarCuentaPersonal(CuentaPersonal cuentapersonal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CuentaPersonal> listarCuentaPersonal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
