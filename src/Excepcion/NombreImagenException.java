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
public class NombreImagenException extends Exception {

    public NombreImagenException() {
        super("Nombre de la imagen repetido, favor ingrese otra");
    }

}
