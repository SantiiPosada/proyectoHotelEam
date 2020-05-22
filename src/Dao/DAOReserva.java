/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOReserva;
import Modelo.ReservaHabitacion;
import java.sql.Connection;
import Conexion.Conexion;
import Excepcion.DatosIncompletosException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mateo
 */
public class DAOReserva implements IDAOReserva {

    @Override
    public boolean guardarReserva(ReservaHabitacion reserva) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO reservaHabitacion (idHuesped,idHabitacion,fechaHoraReserva,fechaHoraLlegada,fechaHoraSalida,fechaHoraCheckIn,fechaHoraCheckOut,estado,estadoServicio) values (?,?,?,?,?,?,?,?,?)");

            pstmt.setInt(1, reserva.getIdHuesped());
            pstmt.setInt(2, reserva.getIdHabitacion());
            pstmt.setString(3, convertirDeDateUtilaDateTime(reserva.getFechaHoraReserva()));
            pstmt.setString(4, convertirDeDateUtilaDateTime(reserva.getFechaHoraLlegada()));
            pstmt.setString(5, convertirDeDateUtilaDateTime(reserva.getFechaHoraSalida()));
            pstmt.setString(6, convertirDeDateUtilaDateTime(reserva.getFechaHoraCheckIn()));
            pstmt.setString(7, convertirDeDateUtilaDateTime(reserva.getFechaHoraCheckOut()));
            pstmt.setString(8, reserva.getEstado());
            pstmt.setString(9, reserva.getEstadoServicio());
   pstmt.executeUpdate();
            desicion = true;

        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1048) {
                throw new DatosIncompletosException();
            }

            desicion = false;
        }
        return desicion;
    }

  private String convertirDeDateUtilaDateTime(Date uDate) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(uDate);

        return currentTime;
    }

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
