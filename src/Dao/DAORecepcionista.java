/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Recepcionista;
import java.sql.Connection;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class DAORecepcionista {

    public boolean guardarRecepcionista(Recepcionista recepcionista) {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO recepcionista" + " (id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,contrasena) values(?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, recepcionista.getId());
            pstmt.setString(2, recepcionista.getCedula());
            pstmt.setString(3, recepcionista.getNombrecompleto());
            pstmt.setString(4, recepcionista.getGenero());
            pstmt.setString(5, recepcionista.getCorreo());
            pstmt.setString(6, recepcionista.getTelefono());
            pstmt.setDate(7, convertirDeDateUtilaDateSql(recepcionista.getFechanacimiento()));
            pstmt.setString(8, recepcionista.getContrasena());
            pstmt.executeUpdate();
            desicion = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al insertar");
            desicion = false;

        }
        return desicion;
    }

    public Recepcionista buscarRecepcionista(int iddocente) {
        Docente docente = new Docente();
        try (Connection con = conexion.getConnetion()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT idDocente,Cedula,Nombre,Apellido,Direccion,Telefono,Correo,Fecha_nacimiento FROM Docente"
                    + " " + "WHERE idDocente=?");
            pstmt.setInt(1, iddocente);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                docente.setId(respuesta.getInt("idDocente"));
                docente.setCedula(respuesta.getString("Cedula"));
                docente.setNombre(respuesta.getString("Nombre"));
                docente.setApellido(respuesta.getString("Apellido"));
                docente.setDireccion(respuesta.getString("Direccion"));
                docente.setTelefono(respuesta.getString("Telefono"));
                docente.setCorreo(respuesta.getString("Correo"));
                docente.setFecha_nacimiento(respuesta.getDate("Fecha_nacimiento"));
                return docente;
            }
        } catch (SQLException ex) {
            docente = null;
            ex.printStackTrace();

        }
        return null;
    }

    public boolean modificarDocente(Docente docente) {
        boolean desicion = false;
        try (Connection con = conexion.getConnetion()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE Docente SET  idDocente=?, Cedula=?, Nombre=?, Apellido=?, Direccion=?, Telefono=?, Correo=?, Fecha_nacimiento=? WHERE idDocente=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setInt(1, docente.getId());
            pstmt.setString(2, docente.getCedula());
            pstmt.setString(3, docente.getNombre());//posicion 2=nombre Valor
            pstmt.setString(4, docente.getApellido());//posicion 3=salario valor
            pstmt.setString(5, docente.getDireccion());
            pstmt.setString(6, docente.getTelefono());
            pstmt.setString(7, docente.getCorreo());
            pstmt.setDate(8, convertirDeDateUtilaDateSql(docente.getFecha_nacimiento()));
            pstmt.setInt(9, docente.getId());
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

    public ArrayList<Docente> listarDocente() {
        try (Connection con = conexion.getConnetion()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT idDocente,Cedula,Nombre,Apellido,Direccion,Telefono,Correo,Fecha_nacimiento FROM Docente");

            // pstmt.setInt(1, id);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Docente> ListaDocente = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    Docente docente = new Docente();

                    docente.setId(respuesta.getInt("idDocente"));
                    docente.setCedula(respuesta.getString("Cedula"));
                    docente.setNombre(respuesta.getString("Nombre"));
                    docente.setApellido(respuesta.getString("Apellido"));
                    docente.setDireccion(respuesta.getString("Direccion"));
                    docente.setTelefono(respuesta.getString("Telefono"));
                    docente.setCorreo(respuesta.getString("Correo"));
                    docente.setFecha_nacimiento(respuesta.getDate("Fecha_nacimiento"));

                    ListaDocente.add(docente);

                } else {
                    condicion = false;
                }
            }

            return ListaDocente;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return listarDocente();
    }

    private java.sql.Date convertirDeDateUtilaDateSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
