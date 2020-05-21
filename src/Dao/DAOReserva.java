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
            pstmt.setDate(3, convertirDeDateUtilaDateSql(reserva.getFechaHoraReserva()));
            pstmt.setDate(4, convertirDeDateUtilaDateSql(reserva.getFechaHoraLlegada()));
            pstmt.setDate(5, convertirDeDateUtilaDateSql(reserva.getFechaHoraSalida()));
            pstmt.setDate(6, convertirDeDateUtilaDateSql(reserva.getFechaHoraCheckIn()));
            pstmt.setDate(7, convertirDeDateUtilaDateSql(reserva.getFechaHoraCheckOut()));
            pstmt.setString(8, reserva.getEstado());
            pstmt.setString(9, reserva.getEstadoServicio());

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

    /**
     * metodo que permite pasar la fecha de tipo java.util.Date a java.sql.Date
     *
     * @param uDate fecha de tipo java.util.Date que se desee cambiar a
     * java.sql.Date
     * @return la fecha lista para ser guardada en mySql
     * @throws DatosIncompletosException si la fecha es null
     */
    private java.sql.Date convertirDeDateUtilaDateSql(java.util.Date uDate) throws DatosIncompletosException {
        if (uDate == null) {
            throw new DatosIncompletosException();
        }
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;

    }

   

}
