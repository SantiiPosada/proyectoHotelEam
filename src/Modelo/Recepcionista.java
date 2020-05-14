/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class Recepcionista {

    private int id;
    private String cedula;
    private String nombrecompleto;
    private String genero;
    private String correo;
    private String telefono;
    private Date fechanacimiento;
    private String contrasena;
    private String estado;

    public Recepcionista() {
        this.id = 0;
        this.cedula = null;
        this.nombrecompleto = null;
        this.genero = null;
        this.correo = null;
        this.telefono = null;
        this.fechanacimiento = null;
        this.contrasena = null;
        this.estado = null;
    }

    public Recepcionista(int id, String cedula, String nombrecompleto, String genero, String correo, String telefono, Date fechanacimiento, String contrasena, String estado) {
        this.id = id;
        this.cedula = cedula;
        this.nombrecompleto = nombrecompleto;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.fechanacimiento = fechanacimiento;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
