/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOHuesped;
import Excepcion.BuscarHuespedException;
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.DatosIncompletosException;
import Excepcion.TelefonoException;
import Modelo.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago
 */
public class DaoHuesped implements IDAOHuesped {

    @Override
    public boolean guardarHuesped(Huesped huesped) throws CedulaException, CorreoException, DatosIncompletosException, TelefonoException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO huesped (cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,nacionalidad,contrasena,tipo,estado) values (?,?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, huesped.getCedula());
            pstmt.setString(2, huesped.getNombrecompleto());
            pstmt.setString(3, huesped.getGenero());
            pstmt.setString(4, huesped.getCorreo());
            pstmt.setString(5, huesped.getTelefono());
            pstmt.setDate(6, convertirDeDateUtilaDateSql(huesped.getFechanacimiento()));
            pstmt.setString(7, huesped.getNacionalidad());
            pstmt.setString(8, huesped.getContrasena());
            pstmt.setString(9, huesped.getTipo());
            pstmt.setString(10, huesped.getEstado());
            pstmt.executeUpdate();
            desicion = true;
        } catch (SQLException ex) {
             ex.printStackTrace();
             JOptionPane.showMessageDialog(null, ex.getMessage()+"variable del error "+extraerVariable(ex.getMessage()));
             
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage());
                switch (variable) {
                    case "cedula":
                        throw new CedulaException();
                    case "correo":
                        throw new CorreoException();
                    case "telefono":
                        throw new TelefonoException();
                    default:
                        break;
                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }

            desicion = false;
        }
        return desicion;
    }

    @Override
    public Huesped buscarHuesped(String cedula)throws BuscarHuespedException   {
        Huesped huesped = new Huesped();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,nacionalidad,contrasena,tipo,estado FROM huesped where cedula=?");
            pstmt.setString(1, cedula);
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
            throw new BuscarHuespedException();

        }
        return null;
    }

    @Override
    public ArrayList<Huesped> listarHuesped() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,nacionalidad,contrasena,tipo,estado FROM huesped");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Huesped> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    Huesped huesped = new Huesped();

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

                    listar.add(huesped);

                } else {
                    condicion = false;
                }
            }

            return listar;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al listar");
        }
        return null;
    }

    @Override
    public boolean modificarHuesped(Huesped huesped) throws CedulaException, CorreoException, TelefonoException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE huesped SET  cedula=?, nombreCompleto=?, genero=?, correo=?, telefono=?, fechaNacimiento=?, nacionalidad=?, contrasena=?,tipo=?,estado=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, huesped.getCedula());
            pstmt.setString(2, huesped.getNombrecompleto());
            pstmt.setString(3, huesped.getGenero());
            pstmt.setString(4, huesped.getCorreo());
            pstmt.setString(5, huesped.getTelefono());
            pstmt.setDate(6, convertirDeDateUtilaDateSql(huesped.getFechanacimiento()));
            pstmt.setString(7, huesped.getNacionalidad());
            pstmt.setString(8, huesped.getContrasena());
            pstmt.setString(9, huesped.getTipo());
            pstmt.setString(10, huesped.getEstado());
            pstmt.setInt(11, huesped.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage());
                switch (variable) {
                    case "cedula":
                        throw new CedulaException();
                    case "correo":
                        throw new CorreoException();
                    case "telefono":
                        throw new TelefonoException();
                    default:
                        break;
                }
            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }

        return desicion;
    }

    /**
     * Método extraer la variable que tuvo el codigo de error 1062
     *
     * @param variable mensaje de error de sql (ex.getMessage())
     * @return nombre de la variable que tiene el error
     */
    private String extraerVariable(String variable) {
        int inicio = variable.indexOf(".");
        int fin = variable.indexOf("'", inicio + 1);
        return variable.substring(inicio + 1, fin);
    }

    /**
     * metodo que permite pasar la fecha de tipo java.util.Date a java.sql.Date
     *
     * @param uDate fecha de tipo java.util.Date que se desee cambiar a
     * java.sql.Date
     * @return la fecha lista para ser guardada en mySql
     */
    private java.sql.Date convertirDeDateUtilaDateSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;

    }
}
