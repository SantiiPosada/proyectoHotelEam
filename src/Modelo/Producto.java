/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class Producto {

    private int id;
    private int idCategoriaProducto;
    private String nombre;
    private String cantidad;
    private String precioUnitario;
    private byte[] imagen;
    private String descripcion;
    private String estado;

    public Producto() {
        this.id = 0;
        this.idCategoriaProducto = 0;
        this.nombre = null;
        this.cantidad = null;
        this.precioUnitario = null;
        this.imagen = null;
        this.descripcion = null;
        this.estado = null;
    }

    public Producto(int id, int idCategoriaProducto, String nombre, String cantidad, String precioUnitario, byte[] imagen, String descripcion, String estado) {
        this.id = id;
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
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

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   


}
