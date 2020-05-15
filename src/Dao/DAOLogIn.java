/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOLogIn;
import Modelo.Administrador;
import Modelo.Huesped;
import Modelo.Recepcionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santiago
 */
public class DAOLogIn implements IDAOLogIn {

    @Override
    public Huesped LogInHuesped(String cedula, String contrasena) {
        Huesped huesped = new Huesped();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,nacionalidad,contrasena,tipo,estado FROM huesped where cedula=? AND contrasena=?");
            pstmt.setString(1, cedula);
            pstmt.setString(2, contrasena);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                huesped.setId(respuesta.getInt("id"));
                huesped.setCedula(respuesta.getString("cedula"));
                huesped.setNombrecompleto(respuesta.getString("nombreCompleto"));
                huesped.setGenero(respuesta.getString("genero"));
                huesped.setCorreo(respuesta.getString("correo"));
                huesped.setTelefono(respuesta.getString("telefono"));
                huesped.setFechanacimiento(respuesta.getDate("fechaNacimiento"));
                huesped.setNacionalidad(respuesta.getString("nacionalidad"));
                huesped.setContrasena(respuesta.getString("contrasena"));
                huesped.setTipo(respuesta.getString("tipo"));
                huesped.setEstado(respuesta.getString("estado"));
                return huesped;
            }
        } catch (SQLException ex) {
            huesped = null;
        }
        return null;
    }

    @Override
    public Recepcionista LogInRecepcionista(String cedula, String contrasena) {
        Recepcionista recepcionista = new Recepcionista();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,contrasena,estado FROM recepcionista WHERE cedula=? AND contrasena=?");
            pstmt.setString(1, cedula);
            pstmt.setString(2, contrasena);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                recepcionista.setId(respuesta.getInt("id"));
                recepcionista.setCedula(respuesta.getString("cedula"));
                recepcionista.setNombrecompleto(respuesta.getString("nombreCompleto"));
                recepcionista.setGenero(respuesta.getString("genero"));
                recepcionista.setCorreo(respuesta.getString("correo"));
                recepcionista.setTelefono(respuesta.getString("telefono"));
                recepcionista.setFechanacimiento(respuesta.getDate("fechaNacimiento"));
                recepcionista.setContrasena(respuesta.getString("contrasena"));
                recepcionista.setEstado(respuesta.getString("estado"));
                return recepcionista;
            }
        } catch (SQLException ex) {
            recepcionista = null;

        }
        return null;
    }

    @Override
    public Administrador LogInAdministrador(String cedula, String contrasena) {
        Administrador administrador = new Administrador();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,cedula,nombreCompleto,contrasena FROM administrador WHERE cedula=? AND contrasena=?");
            pstmt.setString(1, cedula);
            pstmt.setString(2, contrasena);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                administrador.setId(respuesta.getInt("id"));
                administrador.setCedula(respuesta.getString("cedula"));
                administrador.setNombrecompleto(respuesta.getString("nombreCompleto"));
                administrador.setContrasena(respuesta.getString("contrasena"));

                return administrador;
            }
        } catch (SQLException ex) {
            administrador = null;

        }
        return null;
    }

}
