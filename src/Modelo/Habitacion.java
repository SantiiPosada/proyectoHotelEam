/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.Icon;

/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class Habitacion {

    private int id;
    private String nombre;
    private String piso;
    private String bano;
    private String sala;
    private String estado;
    private String nombreImagen;
    private Icon imagen;
    private String descripcion;
    private String valorPorNoche;

    public Habitacion() {
        this.id = 0;
        this.nombre = null;
        this.piso = null;
        this.bano = null;
        this.sala = null;
        this.estado = null;
        this.nombreImagen = null;
        this.imagen = null;
        this.descripcion = null;
        this.valorPorNoche = null;
    }

    public Habitacion(int id, String nombre, String piso, String bano, String sala, String estado, String nombreImagen, Icon imagen, String descripcion, String valorPorNoche) {
        this.id = id;
        this.nombre = nombre;
        this.piso = piso;
        this.bano = bano;
        this.sala = sala;
        this.estado = estado;
        this.nombreImagen = nombreImagen;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.valorPorNoche = valorPorNoche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getBano() {
        return bano;
    }

    public void setBano(String bano) {
        this.bano = bano;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorPorNoche() {
        return valorPorNoche;
    }

    public void setValorPorNoche(String valorPorNoche) {
        this.valorPorNoche = valorPorNoche;
    }

}
