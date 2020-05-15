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
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.DatosIncompletosException;
import Excepcion.TelefonoException;
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
    public boolean guardarRecepcionista(Recepcionista recepcionista) throws CedulaException, CorreoException, DatosIncompletosException, TelefonoException {
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

            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "recepcionista.cedul":
                        throw new CedulaException();
                    case "recepcionista.corre":
                        throw new CorreoException();
                    case "recepcionista.telefon":
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
    public Recepcionista buscarRecepcionista(String cedula) {
        Recepcionista recepcionista = new Recepcionista();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT id,cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,contrasena,estado FROM recepcionista"
                    + " " + "WHERE cedula=?");
            pstmt.setString(1, cedula);
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
    public boolean modificarRecepcionista(Recepcionista recepcionista) throws CedulaException, CorreoException, DatosIncompletosException, TelefonoException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE recepcionista SET  cedula=?, nombreCompleto=?, genero=?, correo=?, telefono=?, fechaNacimiento=?, contrasena=?, estado=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, recepcionista.getCedula());
            pstmt.setString(2, recepcionista.getNombrecompleto());//posicion 2=nombre Valor
            pstmt.setString(3, recepcionista.getGenero());
            pstmt.setString(4, recepcionista.getCorreo());
            pstmt.setString(5, recepcionista.getTelefono());
            pstmt.setDate(6, convertirDeDateUtilaDateSql(recepcionista.getFechanacimiento()));
            pstmt.setString(7, recepcionista.getContrasena());
            pstmt.setString(8, recepcionista.getEstado());
            pstmt.setInt(9, recepcionista.getId());
            int res = pstmt.executeUpdate();//retorna 0,1 o fallo al insertar

            desicion = res > 0;

        } catch (SQLException e) {
            int codigo = e.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(e.getMessage(), extraerDosUltimasLetras(e.getMessage()));
                switch (variable) {
                    case "recepcionista.cedul":
                        throw new CedulaException();
                    case "recepcionista.corre":
                        throw new CorreoException();
                    case "recepcionista.telefon":
                        throw new TelefonoException();
                    default:
                        break;
                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }

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

                    recepcionista.setId(respuesta.getInt("id"));
                    recepcionista.setCedula(respuesta.getString("cedula"));
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
            //  e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return listarRecepcionista();
    }

    /**
     * Método para extraer las dos ultmias letras de una cadena de texto
     *
     * @param variable cadena de texto
     * @return dos ultimos datos de la cadena de texto
     */
    private String extraerDosUltimasLetras(String variable) {
        int tamano = variable.length();
        return variable.substring((tamano - 2), tamano);
    }

    /**
     * Método extraer la variable que tuvo el codigo de error 1062
     *
     * @param variable mensaje de error de sql (ex.getMessage())
     * @param termina dos ultimos datos que terminar del mensaje del error
     * @return nombre de la variable que tiene el error
     */
    private String extraerVariable(String variable, String termina) {
        int inicio = variable.indexOf("key '");
        int fin = variable.indexOf(termina, inicio + 1);
        return variable.substring(inicio + 5, fin);
    }

    /**
     * metodo que permite pasar la fecha de tipo java.util.Date a java.sql.Date
     *
     * @param uDate fecha de tipo java.util.Date que se desee cambiar a
     * java.sql.Date
     * @return la fecha lista para ser guardada en mySql
     * @throws DatosIncompletosException si la fecha es null
     */
    private java.sql.Date convertirDeDateUtilaDateSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
