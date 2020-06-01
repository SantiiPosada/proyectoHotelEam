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
public class DTOHistorialHospedaje {

    private int idReserva;
    private int idHabitacion;
    private String nombreHabitacion;
    private String valorNoche;
    private Date fechaCheckin;
    private Date fechaCheckout;
    private String EstadoReserva;
    private int idHuesped;
    private String NombreHuesped;
    private String ValorTotalaPagar;

    public DTOHistorialHospedaje() {

    }

    public DTOHistorialHospedaje(int idReserva, int idHabitacion, String nombreHabitacion, String valorNoche, Date fechaCheckin, Date fechaCheckout, String EstadoReserva, int idHuesped, String NombreHuesped, String ValorTotalaPagar) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.nombreHabitacion = nombreHabitacion;
        this.valorNoche = valorNoche;
        this.fechaCheckin = fechaCheckin;
        this.fechaCheckout = fechaCheckout;
        this.EstadoReserva = EstadoReserva;
        this.idHuesped = idHuesped;
        this.NombreHuesped = NombreHuesped;
        this.ValorTotalaPagar = ValorTotalaPagar;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public String getValorNoche() {
        return valorNoche;
    }

    public void setValorNoche(String valorNoche) {
        this.valorNoche = valorNoche;
    }

    public Date getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(Date fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public Date getFechaCheckout() {
        return fechaCheckout;
    }

    public void setFechaCheckout(Date fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    public String getEstadoReserva() {
        return EstadoReserva;
    }

    public void setEstadoReserva(String EstadoReserva) {
        this.EstadoReserva = EstadoReserva;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombreHuesped() {
        return NombreHuesped;
    }

    public void setNombreHuesped(String NombreHuesped) {
        this.NombreHuesped = NombreHuesped;
    }

    public String getValorTotalaPagar() {
        return ValorTotalaPagar;
    }

    public void setValorTotalaPagar(String ValorTotalaPagar) {
        this.ValorTotalaPagar = ValorTotalaPagar;
    }

}
