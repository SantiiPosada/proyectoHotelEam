/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcion;

/**
 *
 * @author santiago
 */
public class CorreoException extends Exception{
    public  CorreoException(){
        super("Correo existente, favor ingrese otro");
    }
}
