/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOHistorialCuentaPersonal;
import Modelo.HistorialCuentaPersonal;
import Conexion.Conexion;
import Excepcion.DatosIncompletosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOHistorialCuentaPersonal implements IDAOHistorialCuentaPersonal {

    @Override
    public boolean guardarHistorialCuentaPersonal(HistorialCuentaPersonal historial) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO historialCuentaPersonal (idCuentaPersonal,idProducto,cantidad) values (?,?,?)");

            pstmt.setInt(1, historial.getIdCuentaPersonal());
            pstmt.setInt(2, historial.getIdProducto());
            pstmt.setString(3, historial.getCantidad());
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
    public ArrayList<HistorialCuentaPersonal> listarHistorialPersonal() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  idCuentaPersonal,idProducto,cantidad FROM historialCuentaPersonal");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<HistorialCuentaPersonal> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    HistorialCuentaPersonal historial = new HistorialCuentaPersonal();

                    historial.setIdCuentaPersonal(respuesta.getInt("idCuentaPersonal"));
                    historial.setIdProducto(respuesta.getInt("idProducto"));
                    historial.setCantidad(respuesta.getString("cantidad"));
                    listar.add(historial);

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
     * Método para extraer las dos ultmias letras de una cadena de texto
     *
     * @param variable cadena de texto
     * @return dos ultimos datos de la cadena de texto
     */
    private String extraerDosUltimasLetras(String variable) {
        int tamano = variable.length();
        return variable.substring((tamano - 2), tamano);
    }

}
