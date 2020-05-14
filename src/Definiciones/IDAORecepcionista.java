/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Modelo.Recepcionista;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAORecepcionista {

    /**
     * Método para agregar recepcionista
     *
     * @param recepcionista este parametro recibe un objeto de tipo
     * recepcionista
     * @return un boolean con la condicion si se genero
     */
    public boolean guardarRecepcionista(Recepcionista recepcionista);

    /**
     * Metodo para buscar recepcionista
     *
     * @param id este parametro recibe el identificador del recepcionista que se
     * desea buscar
     * @return un objeto tipo recepcionista
     */
    public Recepcionista buscarRecepcionista(int id);

    /**
     * Metodo para modificar recepcionista
     *
     * @param recepcionista este parametro recibe un objeto tipo recepcionista
     * @return un boolean con la condicion si se genero
     */
    public boolean modificarRecepcionista(Recepcionista recepcionista);

    /**
     * /**
     * Método para listar docentes
     *
     * @return una lista con todos los recepcionistas agregados
     */
    public ArrayList<Recepcionista> listarRecepcionista();

}
