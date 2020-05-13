/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class HistorialCuentaPersonal {

    private int id;
    private int idCuentaPersonal;
    private int idProducto;
    private String cantidad;

    public HistorialCuentaPersonal() {
        this.id = 0;
        this.idCuentaPersonal = 0;
        this.idProducto = 0;
        this.cantidad = null;
    }

    public HistorialCuentaPersonal(int id, int idCuentaPersonal, int idProducto, String cantidad) {
        this.id = id;
        this.idCuentaPersonal = idCuentaPersonal;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCuentaPersonal() {
        return idCuentaPersonal;
    }

    public void setIdCuentaPersonal(int idCuentaPersonal) {
        this.idCuentaPersonal = idCuentaPersonal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

}
