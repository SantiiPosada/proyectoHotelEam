/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Modelo.CompraHabitacion;
import Modelo.ReservaHabitacion;
import java.util.ArrayList;

/**
 *
 * @author santiago
 */
public interface IDAOCompraHabitacion {
    
    /**
     * Metodo encargado de guardar compra habitacion
     *
     * @param compra recibe la compra
     * @return verdadero si guardo compra,falso si no
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
  public boolean guardarCompra(CompraHabitacion compra) throws DatosIncompletosException ;

    
    /**
     * Método para listar compra habitacion
     *
     * @return una lista con las compras registradas
     */
      public ArrayList<CompraHabitacion> listarCompra() ;
       
       /**
        * Metodo encargado de modificar la compra habitacion
        * @param estado que desea modificar
        * @param estadoServicio que desea modificar
        * @param id  para realizar la modificación     
        * @return verdadero si modifica falso si no lo hace
        * @throws DatosIncompletosException 
        */
     public boolean modificarCompraHabitacion(String estado, String estadoServicio, int id) throws DatosIncompletosException;
             
}
