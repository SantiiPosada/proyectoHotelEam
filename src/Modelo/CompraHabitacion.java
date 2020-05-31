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
public class CompraHabitacion {

    private int id;
    private int idHuesped;
    private int idHabitacion;
    private Date fechaHoraCompra;
    private Date fechaHoraLlegada;
    private Date fechaHoraSalida;
    private Date fechaHoraCheckIn;
    private Date fechaHoraCheckOut;
    private String estado;
    private String estadoServicio;

    public CompraHabitacion() {
        this.id = 0;
        this.idHuesped = 0;
        this.idHabitacion = 0;
        this.fechaHoraCompra = null;
        this.fechaHoraLlegada = null;
        this.fechaHoraSalida = null;
        this.fechaHoraCheckIn = null;
        this.fechaHoraCheckOut = null;
        this.estado = null;
        this.estadoServicio = null;
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

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Date getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(Date fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Date getFechaHoraCheckIn() {
        return fechaHoraCheckIn;
    }

    public void setFechaHoraCheckIn(Date fechaHoraCheckIn) {
        this.fechaHoraCheckIn = fechaHoraCheckIn;
    }

    public Date getFechaHoraCheckOut() {
        return fechaHoraCheckOut;
    }

    public void setFechaHoraCheckOut(Date fechaHoraCheckOut) {
        this.fechaHoraCheckOut = fechaHoraCheckOut;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }
    
    
    
    

   
    
    
    
    

}
