/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class Multa {

    int id;
    int idHuesped;
    String cantidadPagar;
    String estado;

    public Multa() {
        this.id = 0;
        this.idHuesped = 0;
        this.cantidadPagar = null;
        this.estado = null;
    }

    public Multa(int id, int idHuesped, String cantidadPagar, String estado) {
        this.id = id;
        this.idHuesped = idHuesped;
        this.cantidadPagar = cantidadPagar;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getCantidadPagar() {
        return cantidadPagar;
    }

    public void setCantidadPagar(String cantidadPagar) {
        this.cantidadPagar = cantidadPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
