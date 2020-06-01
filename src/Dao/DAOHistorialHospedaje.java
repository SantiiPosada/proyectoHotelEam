/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.DTOHistorialHospedaje;
import Definiciones.IDAOHistorialHospedaje;
import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mateo
 */
public class DAOHistorialHospedaje implements IDAOHistorialHospedaje {

    @Override
    public ArrayList<DTOHistorialHospedaje> HistorialHospedaje() {

        ArrayList<DTOHistorialHospedaje> listahistorial = new ArrayList<>();
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("select r.id,h.id,h.nombre,h.valorPorNoche,r.fechaHoraCheckIn,r.fechaHoraCheckOut,r.estado,hu.id,hu.nombreCompleto,c.valorApagar from reservahabitacion r join huesped hu on r.idHuesped=hu.id join habitacion h on h.id=r.idHabitacion join cuentapersonal c  on c.idReservaHabitacion=r.id");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    DTOHistorialHospedaje historial = new DTOHistorialHospedaje();

                    historial.setIdReserva(respuesta.getInt(1));
                    historial.setIdHabitacion(respuesta.getInt(2));
                    historial.setNombreHabitacion(respuesta.getString(3));
                    historial.setValorNoche(respuesta.getString(4));
                    historial.setFechaCheckin(convertirDeDatetimeUtilaDate(respuesta.getString(5)));
                    historial.setFechaCheckout(convertirDeDatetimeUtilaDate(respuesta.getString(6)));
                    historial.setEstadoReserva(respuesta.getString(7));
                    historial.setIdHuesped(respuesta.getInt(8));
                    historial.setNombreHuesped(respuesta.getString(9));
                    historial.setValorTotalaPagar(respuesta.getString(10));
                    listahistorial.add(historial);

                } else {
                    condicion = false;
                }
            }

            return listahistorial;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return listahistorial;

    }

    /**
     * Metodo convertir el datetime de la base de datos a tipo date
     *
     * @param datetime objeto de la fechatime de la base dato
     * @return objeto tipo dato
     */
    private Date convertirDeDatetimeUtilaDate(String datetime) {
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//      dd/MM/yyyy
        try {
            Date date6 = formatter6.parse(datetime);
            return date6;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }
}
