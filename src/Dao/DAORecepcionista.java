/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Recepcionista;
import java.sql.Connection;
import Conexion.Conexion;
import Definiciones.IDAORecepcionista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAORecepcionista implements IDAORecepcionista {

    @Override
    public boolean guardarRecepcionista(Recepcionista recepcionista) {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO recepcionista" + " (id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,contrasena,estado) values(?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, recepcionista.getId());
            pstmt.setString(2, recepcionista.getCedula());
            pstmt.setString(3, recepcionista.getNombrecompleto());
            pstmt.setString(4, recepcionista.getGenero());
            pstmt.setString(5, recepcionista.getCorreo());
            pstmt.setString(6, recepcionista.getTelefono());
            pstmt.setDate(7, convertirDeDateUtilaDateSql(recepcionista.getFechanacimiento()));
            pstmt.setString(8, recepcionista.getContrasena());
            pstmt.setString(9, recepcionista.getEstado());
            pstmt.executeUpdate();
            desicion = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al insertar");
            desicion = false;

        }
        return desicion;
    }

    @Override
    public Recepcionista buscarRecepcionista(int id) {
        Recepcionista recepcionista = new Recepcionista();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,contrasena,estado FROM recepcionista"
                    + " " + "WHERE id=?");
            pstmt.setInt(1, id);
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
            ex.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean modificarRecepcionista(Recepcionista recepcionista) {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE recepcionista SET  id=?, cedula=?, nombreCompleto=?, genero=?, correo=?, telefono=?, fechaNacimiento=?, contrasena=?, estado=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setInt(1, recepcionista.getId());
            pstmt.setString(2, recepcionista.getCedula());
            pstmt.setString(3, recepcionista.getNombrecompleto());//posicion 2=nombre Valor
            pstmt.setString(4, recepcionista.getGenero());
            pstmt.setString(5, recepcionista.getCorreo());
            pstmt.setString(6, recepcionista.getTelefono());
            pstmt.setDate(7, convertirDeDateUtilaDateSql(recepcionista.getFechanacimiento()));
            pstmt.setString(8, recepcionista.getContrasena());
            pstmt.setString(9, recepcionista.getEstado());
            pstmt.setInt(10, recepcionista.getId());
            //pstm.setDate(6,Date.valueOf(txtFecha.getText()));
            int res = pstmt.executeUpdate();//retorna 0,1 o fallo al insertar

            if (res > 0) {
                desicion = true;
            } else {
                desicion = false;
            }

        } catch (SQLException e) {
            desicion = false;
            e.printStackTrace();

        }
        return desicion;
    }

    @Override
    public ArrayList<Recepcionista> listarRecepcionista() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,contrasena,estado FROM recepcionista");

            // pstmt.setInt(1, id);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Recepcionista> listarecepcionista = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    Recepcionista recepcionista = new Recepcionista();

                    recepcionista.setId(respuesta.getInt("idDocente"));
                    recepcionista.setCedula(respuesta.getString("Cedula"));
                    recepcionista.setNombrecompleto(respuesta.getString("nombreCompleto"));
                    recepcionista.setGenero(respuesta.getString("genero"));
                    recepcionista.setCorreo(respuesta.getString("correo"));
                    recepcionista.setTelefono(respuesta.getString("telefono"));
                    recepcionista.setFechanacimiento(respuesta.getDate("fechaNacimiento"));
                    recepcionista.setContrasena(respuesta.getString("contrasena"));
                    recepcionista.setEstado(respuesta.getString("estado"));
                    listarecepcionista.add(recepcionista);

                } else {
                    condicion = false;
                }
            }

            return listarecepcionista;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return listarRecepcionista();
    }

    private java.sql.Date convertirDeDateUtilaDateSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
