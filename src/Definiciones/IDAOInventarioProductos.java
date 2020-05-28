/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.NombreProductoException;
import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOInventarioProductos {

    /**
     * Metodo encargado de guardar Inventario de un producto
     *
     * @param producto recibe el producto
     * @return verdadero si guardo el huesped, falso si no
     * @throws Excepcion.NombreProductoException si el nombre del producto ya se
     * encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean guardarInventarioProductos(Producto producto) throws NombreProductoException, DatosIncompletosException;

    /**
     * Metodo encargado de buscar el inventario de un producto
     *
     * @param nombre recibe el nombre del producto al buscar
     * @return objeto con los datos del producto
     */
    public Producto buscarInventarioProductos(String nombre);

    /**
     * Metodo encargado de modificar el inventario de un producto cuando
     * modifica la imagen
     *
     * @param producto objeto con todos los datos del producto
     * @return si se modifico el inventario,falso si no
     * @throws Excepcion.NombreProductoException si el nombre del producto ya se
     * encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean modificarInventarioProductos(Producto producto) throws NombreProductoException, DatosIncompletosException;

    /**
     * Metodo encargado de modificar el inventario de un producto cuando no
     * modifica la imagen
     *
     * @param producto objeto con todos los datos del producto
     * @return verdadero si se modifico el inventario,falso si no
     * @throws Excepcion.NombreProductoException si el nombre del producto ya se
     * encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean modificarInventarioProductos2(Producto producto) throws NombreProductoException, DatosIncompletosException;

    /**
     * Metodo para listar el inventario de los producto
     *
     * @return una lista con los productos registrados
     */
    public ArrayList<Producto> listaInventarioProducto();
}
