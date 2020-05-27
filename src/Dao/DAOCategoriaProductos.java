/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOCategoriaProductos;
import Modelo.CategoriaProducto;
import java.sql.Connection;
import Conexion.Conexion;
import Excepcion.DatosIncompletosException;
import Excepcion.NombreCategoriaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOCategoriaProductos implements IDAOCategoriaProductos {

    @Override
    public boolean guardarCategoriaProductos(CategoriaProducto categoria) throws NombreCategoriaException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO categoriaProducto (nombre,descripcion,estado) values (?,?,?)");

            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.setString(3, categoria.getEstado());

            pstmt.executeUpdate();
            desicion = true;

        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "categoriaProducto.nombr":
                        throw new NombreCategoriaException();

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
    public CategoriaProducto buscarCategoriaProductos(String nombre) {
        CategoriaProducto categoria = new CategoriaProducto();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,nombre,descripcion,estado FROM categoriaProducto where nombre=?");
            pstmt.setString(1, nombre);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                categoria.setId(respuesta.getInt("id"));
                categoria.setNombre(respuesta.getString("nombre"));
                categoria.setDescripcion(respuesta.getString("descripcion"));
                categoria.setEstado(respuesta.getString("estado"));
                return categoria;
            }
        } catch (SQLException ex) {
            categoria = null;

        }
        return null;

    }

    @Override
    public boolean modificarCategoriaProductos(CategoriaProducto categoria) throws NombreCategoriaException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE categoriaProducto SET  nombre=?, descripcion=?, estado=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.setString(3, categoria.getEstado());
            pstmt.setInt(4, categoria.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "categoriaProducto.nombr":
                        throw new NombreCategoriaException();

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
    public ArrayList<CategoriaProducto> listarCategoriaProductos() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  id,nombre,descripcion,estado FROM categoriaProducto");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<CategoriaProducto> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    CategoriaProducto categoria = new CategoriaProducto();

                    categoria.setId(respuesta.getInt("id"));
                    categoria.setNombre(respuesta.getString("nombre"));
                    categoria.setDescripcion(respuesta.getString("descripcion"));
                    categoria.setEstado(respuesta.getString("estado"));
                    listar.add(categoria);

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
