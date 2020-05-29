/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class CuentaPersonal {

    private int id;
    private int idHuesped;
    private int idReservaHabitacion;
    private String estado;
    private String valorApagar;

    public CuentaPersonal() {
                this.id = 0;
        this.idHuesped = 0;
        this.idReservaHabitacion = 0;
        this.estado = null;
        this.valorApagar = null;
    }

    public CuentaPersonal(int id, int idHuesped, int idReservaHabitacion, String estado, String valorApagar) {
        this.id = id;
        this.idHuesped = idHuesped;
        this.idReservaHabitacion = idReservaHabitacion;
        this.estado = estado;
        this.valorApagar = valorApagar;
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

    public int getIdReservaHabitacion() {
        return idReservaHabitacion;
    }

    public void setIdReservaHabitacion(int idReservaHabitacion) {
        this.idReservaHabitacion = idReservaHabitacion;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(String valorApagar) {
        this.valorApagar = valorApagar;
    }

}
