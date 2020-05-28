/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOInventarioProductos;
import Modelo.Producto;
import java.sql.Connection;
import Conexion.Conexion;
import Excepcion.DatosIncompletosException;
import Excepcion.NombreProductoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOInventarioProductos implements IDAOInventarioProductos {

    @Override
    public boolean guardarInventarioProductos(Producto producto) throws NombreProductoException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO producto (idCategoriaProducto,nombre,cantidad,precioUnitario,imagen,descripcion,estado) values (?,?,?,?,?,?,?)");

            pstmt.setInt(1, producto.getIdCategoriaProducto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getCantidad());
            pstmt.setString(4, producto.getPrecioUnitario());
            pstmt.setBytes(5, producto.getImagen());
            pstmt.setString(6, producto.getDescripcion());
            pstmt.setString(7, producto.getEstado());
            pstmt.executeUpdate();
            desicion = true;

        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "producto.nombr":
                        throw new NombreProductoException();
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
    public Producto buscarInventarioProductos(String nombre) {
        Producto producto = new Producto();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idCategoriaProducto,nombre,cantidad,precioUnitario,imagen,descripcion,estado FROM producto where nombre=?");
            pstmt.setString(1, nombre);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                producto.setId(respuesta.getInt("id"));
                producto.setIdCategoriaProducto(respuesta.getInt("idCategoriaProducto"));
                producto.setNombre(respuesta.getString("nombre"));
                producto.setCantidad(respuesta.getString("cantidad"));
                producto.setPrecioUnitario(respuesta.getString("precioUnitario"));
                producto.setImagen(respuesta.getBytes("imagen"));
                producto.setDescripcion(respuesta.getString("descripcion"));
                producto.setEstado(respuesta.getString("estado"));

                return producto;
            }
        } catch (SQLException ex) {
            producto = null;

        }
        return null;
    }

    @Override
    public boolean modificarInventarioProductos(Producto producto) throws NombreProductoException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE producto SET  idCategoriaProducto=?, nombre=?, cantidad=?, precioUnitario=?, imagen=?, descripcion=?, estado=? WHERE id=?");

            pstmt.setInt(1, producto.getIdCategoriaProducto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getCantidad());
            pstmt.setString(4, producto.getPrecioUnitario());
            pstmt.setBytes(5, producto.getImagen());
            pstmt.setString(6, producto.getDescripcion());
            pstmt.setString(7, producto.getEstado());
            pstmt.setInt(8, producto.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "producto.nombr":
                        throw new NombreProductoException();

                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }

        return desicion;
    }

    @Override
    public boolean modificarInventarioProductos2(Producto producto) throws NombreProductoException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE producto SET  idCategoriaProducto=?, nombre=?, cantidad=?, precioUnitario=?, descripcion=?, estado=? WHERE id=?");

            pstmt.setInt(1, producto.getIdCategoriaProducto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getCantidad());
            pstmt.setString(4, producto.getPrecioUnitario());
            pstmt.setString(5, producto.getDescripcion());
            pstmt.setString(6, producto.getEstado());
            pstmt.setInt(7, producto.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "producto.nombr":
                        throw new NombreProductoException();

                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }

        return desicion;
    }

    @Override
    public ArrayList<Producto> listaInventarioProducto() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idCategoriaProducto,nombre,cantidad,precioUnitario,imagen,descripcion,estado FROM producto");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Producto> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    Producto productos = new Producto();

                    productos.setId(respuesta.getInt("id"));
                    productos.setIdCategoriaProducto(respuesta.getInt("idCategoriaProducto"));
                    productos.setNombre(respuesta.getString("nombre"));
                    productos.setCantidad(respuesta.getString("cantidad"));
                    productos.setPrecioUnitario(respuesta.getString("precioUnitario"));
                    productos.setImagen(respuesta.getBytes("imagen"));
                    productos.setDescripcion(respuesta.getString("descripcion"));
                    productos.setEstado(respuesta.getString("estado"));

                    listar.add(productos);

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
