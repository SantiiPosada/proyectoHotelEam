/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author mateo
 */
public class DTOMulta {

    private int id;
    private int idreserva;
    private String cedula;
    private String nombrehuesped;
    private String nombreHabitacion;
    private Date fechaHoraCheckIn;
    private Date fechaHoraCheckOut;
    private String estadoreservacion;
    private Date fechaHoraReserva;
    private String estadomulta;
    private String cantidadPagar;

    public DTOMulta() {

    }

    public DTOMulta(int id, int idreserva, String cedula, String nombrehuesped, String nombreHabitacion, Date fechaHoraCheckIn, Date fechaHoraCheckOut, String estadoreservacion, Date fechaHoraReserva, String estadomulta, String cantidadPagar) {
        this.id = id;
        this.idreserva = idreserva;
        this.cedula = cedula;
        this.nombrehuesped = nombrehuesped;
        this.nombreHabitacion = nombreHabitacion;
        this.fechaHoraCheckIn = fechaHoraCheckIn;
        this.fechaHoraCheckOut = fechaHoraCheckOut;
        this.estadoreservacion = estadoreservacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.estadomulta = estadomulta;
        this.cantidadPagar = cantidadPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrehuesped() {
        return nombrehuesped;
    }

    public void setNombrehuesped(String nombrehuesped) {
        this.nombrehuesped = nombrehuesped;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
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

    public String getEstadoreservacion() {
        return estadoreservacion;
    }

    public void setEstadoreservacion(String estadoreservacion) {
        this.estadoreservacion = estadoreservacion;
    }

    public Date getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Date fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public String getEstadomulta() {
        return estadomulta;
    }

    public void setEstadomulta(String estadomulta) {
        this.estadomulta = estadomulta;
    }

    public String getCantidadPagar() {
        return cantidadPagar;
    }

    public void setCantidadPagar(String cantidadPagar) {
        this.cantidadPagar = cantidadPagar;
    }

}
