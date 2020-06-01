/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOCompraHabitacion;
import Excepcion.DatosIncompletosException;
import Modelo.CompraHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author santiago
 */
public class DAOcompraHabitacion implements IDAOCompraHabitacion{

    @Override
    public boolean guardarCompra(CompraHabitacion compra) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO compraHabitacion (idHuesped,idHabitacion,fechaHoraCompra,fechaHoraLlegada,fechaHoraSalida,fechaHoraCheckIn,fechaHoraCheckOut,estado,estadoServicio) values (?,?,?,?,?,?,?,?,?)");

            pstmt.setInt(1, compra.getIdHuesped());
            pstmt.setInt(2, compra.getIdHabitacion());
            pstmt.setString(3, convertirDeDateUtilaDateTime(compra.getFechaHoraCompra()));
            pstmt.setString(4, convertirDeDateUtilaDateTime(compra.getFechaHoraLlegada()));
            pstmt.setString(5, convertirDeDateUtilaDateTime(compra.getFechaHoraSalida()));
            pstmt.setString(6, convertirDeDateUtilaDateTime(compra.getFechaHoraCheckIn()));
            pstmt.setString(7, convertirDeDateUtilaDateTime(compra.getFechaHoraCheckOut()));
            pstmt.setString(8, compra.getEstado());
            pstmt.setString(9, compra.getEstadoServicio());
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
    
    @Override
      public ArrayList<CompraHabitacion> listarCompra() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idHuesped,idHabitacion,fechaHoraCompra,fechaHoraLlegada,fechaHoraSalida,fechaHoraCheckIn,fechaHoraCheckOut,estado,estadoServicio FROM compraHabitacion ");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<CompraHabitacion> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    CompraHabitacion compra = new CompraHabitacion();

                    compra.setId(respuesta.getInt("id"));
                    compra.setIdHuesped(respuesta.getInt("idHuesped"));
                    compra.setIdHabitacion(respuesta.getInt("idHabitacion"));
                    compra.setFechaHoraCompra(convertirDeDatetimeUtilaDate(respuesta.getString("fechaHoraCompra")));
                    compra.setFechaHoraLlegada(convertirDeDatetimeUtilaDate(respuesta.getString("fechaHoraLlegada")));
                    compra.setFechaHoraSalida(convertirDeDatetimeUtilaDate(respuesta.getString("fechaHoraSalida")));
                    compra.setFechaHoraCheckIn(convertirDeDatetimeUtilaDate(respuesta.getString("fechaHoraCheckIn")));
                    compra.setFechaHoraCheckOut(convertirDeDatetimeUtilaDate(respuesta.getString("fechaHoraCheckOut")));
                    compra.setEstado(respuesta.getString("estado"));
                    compra.setEstadoServicio(respuesta.getString("estadoServicio"));
                    listar.add(compra);

                } else {
                    condicion = false;
                }
            }

            return listar;
        } catch (SQLException e) {
            System.err.println("Hubo un error al listar");
            e.printStackTrace();

        }
        return null;
    }
    @Override
        public boolean modificarCompraHabitacion(String estado, String estadoServicio, int id) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE compraHabitacion SET  estado=?, estadoServicio=? WHERE id=?;");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, estado);
            pstmt.setString(2, estadoServicio);
            pstmt.setInt(3, id);

            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
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
