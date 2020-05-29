/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mateo
 */
public class DTOProductosCuenta {

    private int idProducto;
    private String nombre;
    private String cantidad;
    private String valortotal;

    public DTOProductosCuenta() {

    }

    public DTOProductosCuenta(int idProducto, String nombre, String cantidad, String valortotal) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valortotal = valortotal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValortotal() {
        return valortotal;
    }

    public void setValortotal(String valortotal) {
        this.valortotal = valortotal;
    }
    
    
}
