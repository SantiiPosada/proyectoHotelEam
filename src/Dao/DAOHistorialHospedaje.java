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

/**
 *
 * @author mateo
 */
public class DAOHistorialHospedaje implements IDAOHistorialHospedaje {

    @Override
    public ArrayList<DTOHistorialHospedaje> HistorialHospedaje() {
        ArrayList<DTOHistorialHospedaje> listaHistorialHospedaje = new ArrayList<>();
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("Select r.id,r.fechaHoraCheckIn,r.idHabitacion,r.estado,c.valorApagar from cuentapersonal c join reservahabitacion r  on c.idReservaHabitacion=r.id where r.idHuesped=?");
            //    pstmt.setInt(1, idHuesped);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    DTOHistorialHospedaje historial = new DTOHistorialHospedaje();

//                    historial.setIdreserva(respuesta.getInt(1));
//                    historial.setFechareservacion(convertirDeDatetimeUtilaDate(respuesta.getString(2)));
//                    historial.setIdhabitacion(respuesta.getInt(3));
//                    historial.setEstado(respuesta.getString(4));
//                    historial.setValor(respuesta.getString(5));
//                    listaHistorialHospedaje.add(historial);
                } else {
                    condicion = false;
                }
            }

            return listaHistorialHospedaje;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return listaHistorialHospedaje;
    }

}
