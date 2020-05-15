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
public class LogInHuespedException extends Exception{
    public LogInHuespedException(){
        super("No se encuentra el huesped registrado, verifique la cedula o la contraseña");
    }
}
