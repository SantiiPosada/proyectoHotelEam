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
public class CorreoFormatoException extends Exception{
    public CorreoFormatoException(){
        super("Correo invalido, verifique que lo haya escrito correctamente");
    }
}
