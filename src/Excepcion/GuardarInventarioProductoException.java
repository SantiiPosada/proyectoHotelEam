/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcion;

/**
 *
 * @author mateo
 */
public class GuardarInventarioProductoException extends Exception {

    public GuardarInventarioProductoException() {
        super("Error al guardar el inventario de productos");
    }
}
