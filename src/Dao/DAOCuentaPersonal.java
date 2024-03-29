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
import Modelo.Habitacion;
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
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idHuesped,idReservaHabitacion,estado,valorApagar FROM cuentaPersonal where idReservaHabitacion=?");
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
    public boolean modificarCuentaPersonal(CuentaPersonal cuentapersonal) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("UPDATE  cuentaPersonal SET estado=?, valorApagar=? WHERE idReservaHabitacion=?");

            pstmt.setString(1, cuentapersonal.getEstado());
            pstmt.setString(2, cuentapersonal.getValorApagar());
            pstmt.setInt(3, cuentapersonal.getIdReservaHabitacion());

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
    public ArrayList<CuentaPersonal> listarCuentaPersonal() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idHuesped,idReservaHabitacion,estado,valorApagar FROM cuentaPersonal");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<CuentaPersonal> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    CuentaPersonal cuenta = new CuentaPersonal();

                    cuenta.setId(respuesta.getInt("id"));
                    cuenta.setIdHuesped(respuesta.getInt("idHuesped"));
                    cuenta.setIdReservaHabitacion(respuesta.getInt("idReservaHabitacion"));
                    cuenta.setEstado(respuesta.getString("estado"));
                    cuenta.setValorApagar(respuesta.getString("valorApagar"));

                    listar.add(cuenta);

                } else {
                    condicion = false;
                }
            }

            return listar;
        } catch (SQLException e) {
            // e.printStackTrace();
            System.err.println("Hubo un error al listar");
        }
        return null;
    }

}
