/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.NombreCategoriaException;
import Modelo.CategoriaProducto;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOCategoriaProductos {

    /**
     * Metodo encargado de guardar categoria producto
     *
     * @param categoria recibe el producto
     * @return verdadero si guardo el huesped, falso si no
     * @throws Excepcion.NombreCategoriaException si el nombre de la categoria
     * ya se encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean guardarCategoriaProductos(CategoriaProducto categoria) throws NombreCategoriaException, DatosIncompletosException;

    /**
     * Metodo encargado de buscar a una categoria de un producto
     *
     * @param nombre recibe el nombre de la categoria al buscar
     * @return objeto con los datos de la categoria
     */
    public CategoriaProducto buscarCategoriaProductos(String nombre);

    /**
     * Metodo encargado de modificar la categoria de un producto
     *
     * @param categoria objeto con todo los datos de la categoria
     * @return verdadero si se modifico la categoria,falso si no
     * @throws Excepcion.NombreCategoriaException si el nombre de la categoria
     * ya se encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean modificarCategoriaProductos(CategoriaProducto categoria) throws NombreCategoriaException, DatosIncompletosException;

    /**
     * Metodo para listar la categoria
     *
     * @return una lista con las categorias registradas
     */
    public ArrayList<CategoriaProducto> listarCategoriaProductos();
}
