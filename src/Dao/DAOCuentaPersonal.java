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
import Excepcion.DatosIncompletosException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class DAOCuentaPersonal implements IDAOCuentaPersonal {

    @Override
    public boolean guardarCuentaPersonal(CuentaPersonal cuentapersonal) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO cuentaPersonal (idHuesped,idReservaHabitacion,estado,valorApagar) values (?,?,?,?)");

            pstmt.setInt(1, cuentapersonal.getIdHuesped());
            pstmt.setInt(2, cuentapersonal.getIdReservaHabitacion());
            pstmt.setString(3, cuentapersonal.getEstado());
            pstmt.setString(4, cuentapersonal.getValorApagar());
            pstmt.executeUpdate();
            desicion = true;

        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1048) {
                throw new DatosIncompletosException();
            }

            desicion = false;
        }
        return desicion;
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
